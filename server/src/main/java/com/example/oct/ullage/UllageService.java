package com.example.oct.ullage;

import com.example.oct.enums.Tables;
import com.example.oct.ullage.dto.UllageDto;
import com.example.oct.ullage.dto.UllageDtoFull;
import com.example.oct.ullage.dto.UllageDtoShort;
import com.example.oct.ullage.dto.UllageMapper;
import com.example.oct.units.api.Api;
import com.example.oct.units.temperature.Temperature;
import com.example.oct.units.vcf.*;
import com.example.oct.units.wcf.Wcf;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UllageService implements IUllageService {

    private final UllageRepository repository;

    /**
     * @param ullage
     * @param name
     * @return Return row from calibration tables, makes interpolation if it requires.
     */
    public UllageDto getByUllageAndTank(double ullage, String name) {
        if (!repository.existsByName(name)) throw new NoSuchElementException("Vessel don't have tank " + name);
        Ullage ull = repository.findByUllageAndName(ullage, name);
        if (ull != null) {
            return UllageMapper.ullageToDto(ull);
        } else {
            Ullage nextUllage = repository.getNextUllage(name, ullage, PageRequest.of(0, 1)).get(0);
            Ullage prevUllage = repository.findById(nextUllage.getId() - 1)
                    .orElseThrow(() -> new NoSuchElementException("Ullage you entered is to low"));

            UllageDto actualUllageDto = calculateActualUllage(List.of(UllageMapper.ullageToDto(prevUllage),
                    UllageMapper.ullageToDto(nextUllage)), ullage);
            return actualUllageDto;
        }
    }

    /**
     * @param ullageDto
     * @param trim
     * @return Return short ullage Dto with tank name, ullage and Volume in m3 taken from calibration tables and with
     * trim correction applied
     */
    public UllageDtoShort getUllage(UllageDto ullageDto, double trim, double api, double temp, Tables tables) {
        Api apiDens;
        Temperature temperature;
        if (tables.equals(Tables.Table6A) || tables.equals(Tables.Table6B)) {
            apiDens = Api.fromApi(api);
            temperature = Temperature.fromFahrenheit(temp);
        } else if (tables.equals(Tables.Table54A) || tables.equals(Tables.Table54B)) {
            apiDens = Api.formDens(api);
            temperature = Temperature.fromCelius(temp);
        } else throw new IllegalStateException("Table is not supported.");

        double trimVolume;

        if (trim < 0) {
            trimVolume = calculateUllageWithTrim(ullageDto.getTovCub1F(), ullageDto.getTovCubEK(), -1, 0, trim);
        } else if (Math.abs(trim) <= 0.01) {
            System.out.println(trim);
            return UllageMapper.dtoFullToShor(calculateUllageWithFullInfo(ullageDto, apiDens, temperature, tables, ullageDto.getTovCubEK()));
        } else if (trim <= 1) {
            trimVolume = calculateUllageWithTrim(ullageDto.getTovCubEK(), ullageDto.getTovCub1A(), 0, 1, trim);
        } else if (trim <= 2) {
            trimVolume = calculateUllageWithTrim(ullageDto.getTovCub1A(), ullageDto.getTovCub2A(), 1, 2, trim);
        } else if (trim <= 3) {
            trimVolume = calculateUllageWithTrim(ullageDto.getTovCub2A(), ullageDto.getTovCub3A(), 2, 3, trim);
        } else if (trim <= 4) {
            trimVolume = calculateUllageWithTrim(ullageDto.getTovCub3A(), ullageDto.getTovCub4A(), 3, 4, trim);
        } else throw new IllegalStateException("Trim is out of table limits");

        return UllageMapper.dtoFullToShor(calculateUllageWithFullInfo(ullageDto, apiDens, temperature, tables, trimVolume));
    }

    /**
     * @param ullages
     * @param actual
     * @return private function for the interpolation between two ullages in tables
     */
    private UllageDto calculateActualUllage(List<UllageDto> ullages, double actual) {
        if (ullages.size() > 2) throw new IllegalStateException("Calculation can me done only between two ullages");
        UllageDto prevUllage = ullages.get(0);
        UllageDto nextUllage = ullages.get(1);
        System.out.println(prevUllage.getTovCubEK());
        System.out.println(nextUllage.getTovCubEK());
        double volEK = prevUllage.getTovCubEK() + ((actual - prevUllage.getUllage())
                / (nextUllage.getUllage() - prevUllage.getUllage()))
                * (nextUllage.getTovCubEK() - prevUllage.getTovCubEK());
        double vol1F = prevUllage.getTovCub1F() + ((actual - prevUllage.getUllage())
                / (nextUllage.getUllage() - prevUllage.getUllage()))
                * (nextUllage.getTovCub1F() - prevUllage.getTovCub1F());
        double vol1A = prevUllage.getTovCub1A() + ((actual - prevUllage.getUllage())
                / (nextUllage.getUllage() - prevUllage.getUllage()))
                * (nextUllage.getTovCub1A() - prevUllage.getTovCub1A());
        double vol2A = prevUllage.getTovCub2A() + ((actual - prevUllage.getUllage())
                / (nextUllage.getUllage() - prevUllage.getUllage()))
                * (nextUllage.getTovCub2A() - prevUllage.getTovCub2A());
        double vol3A = prevUllage.getTovCub3A() + ((actual - prevUllage.getUllage())
                / (nextUllage.getUllage() - prevUllage.getUllage()))
                * (nextUllage.getTovCub3A() - prevUllage.getTovCub3A());
        double vol4A = prevUllage.getTovCub4A() + ((actual - prevUllage.getUllage())
                / (nextUllage.getUllage() - prevUllage.getUllage()))
                * (nextUllage.getTovCub1A() - prevUllage.getTovCub4A());

        return UllageDto.create(prevUllage.getName(), actual, vol1F, volEK, vol1A, vol2A, vol3A, vol4A);

    }

    /**
     *
     * @param volumeLow
     * @param volumeUp
     * @param trimLow
     * @param trimUp
     * @param trim
     * @return Calculate volume m3 with trim
     */
    private double calculateUllageWithTrim(double volumeLow, double volumeUp, double trimLow,
                                           double trimUp, double trim) {

        return volumeLow - (volumeLow - volumeUp) * ((trim - trimLow) / (trimUp - trimLow));
    }

    /**
     * @param dto
     * @param api
     * @param temperature
     * @param tables
     * @param tovCub
     * @return Ullage with full info.
     */
    private UllageDtoFull calculateUllageWithFullInfo(UllageDto dto, Api api, Temperature temperature, Tables tables, double tovCub) {
        UllageDtoFull result = UllageDtoFull.create(dto.getName(), dto.getUllage(), api, temperature, tovCub, 0d,
                0d, 0d, 0d, 0d, 0d, 0d, null);
        Vcf vcf;
        result.setTovBbls(tovCub * 6.28981);
        result.setGovCub(tovCub);
        result.setGovBbls(result.getTovBbls());
        switch (tables) {
            case Table6A:
                vcf = Vcf6A.create(api, temperature);
                break;
            case Table6B:
                vcf = Vcf6B.create(api, temperature);
                break;
            case Table54A:
                vcf = Vcf54A.create(api, temperature);
                break;
            case Table54B:
                vcf = Vcf54B.create(api, temperature);
                break;
            default:
                throw new IllegalStateException("Table not exist");
        }
        Wcf wcf = Wcf.create(vcf);
        if (tables.equals(Tables.Table54A) || tables.equals(Tables.Table54B)) {
            result.setGsvCub(result.getGovCub() * vcf.getVcf());
            result.setGsvBbls(result.getGsvCub() / wcf.getT52());
        } else {
            result.setGsvBbls(result.getGovBbls() * vcf.getVcf());
            result.setGsvCub(result.getGsvBbls() * wcf.getT52());
        }
        result.setVcf(vcf.getVcf());
        result.setMetricTons(wcf.getT13() * result.getGsvBbls());
        result.setLongTons(wcf.getT11() * result.getGsvBbls());
        return result;
    }

}
