package com.example.oct.ullage;

import com.example.oct.ullage.dto.UllageDto;
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

    public UllageDto getUll(double ullage, String name) {
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

    private UllageDto calcUllageDto(List<UllageDto> ullages, double actual) {
        if(ullages.size() > 2) throw new IllegalStateException("Calculation can me done only between two ullages");
        UllageDto prevUllage = ullages.get(0);
        UllageDto nextUllage = ullages.get(1);

        double volEK = prevUllage.getVolEK() + ((actual - prevUllage.getUllage()) / (nextUllage.getUllage() - actual))
                * (nextUllage.getVolEK() - prevUllage.getVolEK());
        double vol1F = prevUllage.getVol1F() + ((actual - prevUllage.getUllage()) / (nextUllage.getUllage() - actual))
                * (nextUllage.getVol1F() - prevUllage.getVol1F());
        double vol1A = prevUllage.getVol1A() + ((actual - prevUllage.getUllage()) / (nextUllage.getUllage() - actual))
                * (nextUllage.getVol1A() - prevUllage.getVol1A());
        double vol2A = prevUllage.getVol2A() + ((actual - prevUllage.getUllage()) / (nextUllage.getUllage() - actual))
                * (nextUllage.getVol2A() - prevUllage.getVol2A());
        double vol3A = prevUllage.getVol3A() + ((actual - prevUllage.getUllage()) / (nextUllage.getUllage() - actual))
                * (nextUllage.getVol3A() - prevUllage.getVol3A());
        double vol4A = prevUllage.getVol4A() + ((actual - prevUllage.getUllage()) / (nextUllage.getUllage() - actual))
                * (nextUllage.getVol1A() - prevUllage.getVol4A());

        return UllageDto.create(prevUllage.getName(), actual, vol1F, volEK, vol1A, vol2A, vol3A, vol4A);

    }


}
