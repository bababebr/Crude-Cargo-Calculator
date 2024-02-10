package com.ship4all.service.crude.service;

import com.ship4all.service.crude.cargo.CargoService;
import com.ship4all.service.crude.cargo.dto.CargoDto;
import com.ship4all.service.crude.enums.Tables;
import com.ship4all.service.crude.model.Api;
import com.ship4all.service.crude.model.Temperature;
import com.ship4all.service.crude.model.UllageReport;
import com.ship4all.service.crude.model.Vcf6B;
import com.ship4all.service.crude.service.interfaces.IUllageReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import com.ship4all.service.crude.model.Vcf;
import com.ship4all.service.crude.model.Vcf54A;
import com.ship4all.service.crude.model.Vcf54B;
import com.ship4all.service.crude.model.Vcf6A;
import com.ship4all.service.crude.model.dto.UllageDto;
import com.ship4all.service.crude.model.dto.UllageDtoFull;
import com.ship4all.service.crude.model.dto.UllageRequestDto;
import com.ship4all.service.crude.mapper.UllageReportMapper;
import com.ship4all.service.crude.model.dto.UllageReportDto;
import com.ship4all.service.crude.model.Wcf;

import java.util.ArrayList;
import java.util.List;

@Service
public class UllageReportService implements IUllageReportService {

    private UllageService ullageService;
    private CargoService cargoService;

    @Autowired
    public UllageReportService(UllageService ullageService, CargoService cargoService) {
        this.ullageService = ullageService;
        this.cargoService = cargoService;
    }


    public List<UllageReportDto> getReport(List<UllageRequestDto> requestDtos, String cargoName) {
        List<UllageReportDto> reports = new ArrayList<>();
        CargoDto cargo = cargoService.getByName(cargoName);
        for (UllageRequestDto requestDto : requestDtos) {
            String tank = requestDto.getTankName();
            Tables table = requestDto.getTable();
            UllageDtoFull ullageDto = getUllage(requestDto, cargo);

            UllageReport tankReport = new UllageReport();
            tankReport.setUllage(ullageDto);
            tankReport.setTable(table.name());
            tankReport.setCargo(cargo);
            tankReport.setTankName(tank);

            reports.add(UllageReportMapper.ullageReportToDto(tankReport));

        }

        return reports;
    }

    /**
     * @param requestDto
     * @return Return short ullage Dto with tank name, ullage and Volume in m3 taken from calibration tables and with
     * trim correction applied
     */
    public UllageDtoFull getUllage(UllageRequestDto requestDto, @Nullable CargoDto cargoDto) {

        Tables tables = requestDto.getTable();
        Api api = cargoDto.getApi().toApi();
        Temperature temp = cargoDto.getTemperature().toTemperature();
        double trim = requestDto.getTrim();
        UllageDto ullageDto = ullageService.getTankUllage(requestDto);

        double trimVolume;

        if (trim < 0) {
            trimVolume = calculateUllageWithTrim(ullageDto.getTovCub1F(), ullageDto.getTovCubEK(), -1, 0, trim);
        } else if (Math.abs(trim) <= 0.01) {
            return calculateUllageWithFullInfo(ullageDto, api, temp, tables, ullageDto.getTovCubEK());
        } else if (trim <= 1) {
            trimVolume = calculateUllageWithTrim(ullageDto.getTovCubEK(), ullageDto.getTovCub1A(), 0, 1, trim);
        } else if (trim <= 2) {
            trimVolume = calculateUllageWithTrim(ullageDto.getTovCub1A(), ullageDto.getTovCub2A(), 1, 2, trim);
        } else if (trim <= 3) {
            trimVolume = calculateUllageWithTrim(ullageDto.getTovCub2A(), ullageDto.getTovCub3A(), 2, 3, trim);
        } else if (trim <= 4) {
            trimVolume = calculateUllageWithTrim(ullageDto.getTovCub3A(), ullageDto.getTovCub4A(), 3, 4, trim);
        } else throw new IllegalStateException("Trim is out of table limits");

        return calculateUllageWithFullInfo(ullageDto, api, temp, tables, trimVolume);
    }


    /**
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
        Wcf wcf = Wcf.create(api.getApi());
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
