package com.example.oct.ullage;

import com.example.oct.ullage.dto.UllageDto;
import com.example.oct.ullage.dto.UllageDtoShort;
import com.example.oct.ullage.dto.UllageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class UllageService implements IUllageService {

    private final UllageRepository repository;

    public UllageDto getById(Long id) {
        return UllageMapper.ullageToDto(repository.findById(id).get());
    }

    public UllageDto getUllageInfo(double ullage, String name) {
        Ullage ull = repository.findByUllageAndName(ullage, name);
        if (ull != null) {
            return UllageMapper.ullageToDto(ull);
        } else {
            Ullage prevUllage = repository.getNextUllage(name, ullage, PageRequest.of(0, 1)).get(0);
            Ullage nextUllage = repository.findById(prevUllage.getId() + 1).
                    orElseThrow(() -> new NoSuchElementException("Ullage you entered is to high"));

            UllageDto actualUllageDto = calcUllageDto(List.of(UllageMapper.ullageToDto(prevUllage),
                    UllageMapper.ullageToDto(nextUllage)), ullage);
            return actualUllageDto;
        }
    }

    public UllageDtoShort getUllage(UllageDto ullageDto, double trim) {
        double trimVolume;
        if (Math.abs(trim) <= 0.0001) {
            return UllageDtoShort.create(ullageDto.getName(), ullageDto.getUllage(), ullageDto.getTovCubEK());
        } else if (trim <= 0) {
            trimVolume = calculateUllageWithTrim(ullageDto.getTovCub1F(), ullageDto.getTovCubEK(), -1, 0, trim);
        } else if (trim <= 1) {
            trimVolume = calculateUllageWithTrim(ullageDto.getTovCubEK(), ullageDto.getTovCub1A(), 0, 1, trim);
        } else if (trim <= 2) {
            trimVolume = calculateUllageWithTrim(ullageDto.getTovCub1A(), ullageDto.getTovCub2A(), 1, 2, trim);
        } else if (trim <= 3) {
            trimVolume = calculateUllageWithTrim(ullageDto.getTovCub2A(), ullageDto.getTovCub3A(), 2, 3, trim);
        } else if (trim <= 4) {
            trimVolume = calculateUllageWithTrim(ullageDto.getTovCub3A(), ullageDto.getTovCub4A(), 3, 4, trim);
        } else throw new IllegalStateException("Trim is out of table limits");
        return UllageDtoShort.create(ullageDto.getName(), ullageDto.getUllage(), trimVolume);
    }

    private UllageDto calcUllageDto(List<UllageDto> ullages, double actual) {
        if (ullages.size() > 2) throw new IllegalStateException("Calculation can me done only between two ullages");
        UllageDto prevUllage = ullages.get(0);
        UllageDto nextUllage = ullages.get(1);

        double volEK = prevUllage.getTovCubEK() + ((actual - prevUllage.getUllage()) / (nextUllage.getUllage() - actual))
                * (nextUllage.getTovCubEK() - prevUllage.getTovCubEK());
        double vol1F = prevUllage.getTovCub1F() + ((actual - prevUllage.getUllage()) / (nextUllage.getUllage() - actual))
                * (nextUllage.getTovCub1F() - prevUllage.getTovCub1F());
        double vol1A = prevUllage.getTovCub1A() + ((actual - prevUllage.getUllage()) / (nextUllage.getUllage() - actual))
                * (nextUllage.getTovCub1A() - prevUllage.getTovCub1A());
        double vol2A = prevUllage.getTovCub2A() + ((actual - prevUllage.getUllage()) / (nextUllage.getUllage() - actual))
                * (nextUllage.getTovCub2A() - prevUllage.getTovCub2A());
        double vol3A = prevUllage.getTovCub3A() + ((actual - prevUllage.getUllage()) / (nextUllage.getUllage() - actual))
                * (nextUllage.getTovCub3A() - prevUllage.getTovCub3A());
        double vol4A = prevUllage.getTovCub4A() + ((actual - prevUllage.getUllage()) / (nextUllage.getUllage() - actual))
                * (nextUllage.getTovCub1A() - prevUllage.getTovCub4A());

        return UllageDto.create(prevUllage.getName(), actual, vol1F, volEK, vol1A, vol2A, vol3A, vol4A);

    }

    private double calculateUllageWithTrim(double volumeLow, double volumeUp, double trimLow,
                                           double trimUp, double trim) {

        return volumeLow - (volumeLow - volumeUp) * ((trim - trimLow) / (trimUp - trimLow));

    }


}
