package ru.oil.ullage;

import ru.oil.ullage.dto.UllageDto;
import ru.oil.ullage.dto.UllageMapper;
import ru.oil.ullage.dto.UllageRequestDto;
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
     * @param requestDto ullage
     * @return Return row from calibration tables, makes interpolation if it requires.
     */
    public UllageDto getTankUllage(UllageRequestDto requestDto) {

        validateRequest(requestDto);

        Ullage ull = repository.findByUllageAndName(requestDto.getUllage(), requestDto.getTankName());
        if (ull != null) {
            return UllageMapper.ullageToDto(ull);
        } else {
            Ullage nextUllage = repository.getNextUllage(requestDto.getTankName(),
                    requestDto.getUllage(),
                    PageRequest.of(0, 1)).get(0);
            Ullage prevUllage = repository.findById(nextUllage.getId() - 1)
                    .orElseThrow(() -> new NoSuchElementException("Ullage you entered is to low"));

            UllageDto actualUllageDto = calculateActualUllage(List.of(UllageMapper.ullageToDto(prevUllage),
                    UllageMapper.ullageToDto(nextUllage)), requestDto.getUllage());
            return actualUllageDto;
        }
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
     * Check if request body contains correct tank and ullage is within a table limits
     * @param requestDto
     */
    private void validateRequest(UllageRequestDto requestDto) {
        if (!repository.existsByName(requestDto.getTankName())) {
            throw new NoSuchElementException("Vessel don't have tank " + requestDto.getTankName());
        }
        double maxTankUllage = repository.maxUllage(requestDto.getTankName());
        if (requestDto.getUllage() > maxTankUllage) {
            throw new NoSuchElementException(String.format("Ullage is out of table limit. Max ullage for %s is %s",
                    requestDto.getTankName(), maxTankUllage));
        }
    }

}
