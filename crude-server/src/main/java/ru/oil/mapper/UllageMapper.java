package ru.oil.mapper;

import ru.oil.model.Ullage;
import ru.oil.model.dto.UllageDto;

public class UllageMapper {

    public static UllageDto ullageToDto(Ullage ullage) {
        return UllageDto.create(ullage.getName(),
                ullage.getUllage(),
                ullage.getTovCub1F(),
                ullage.getTovCubEk(),
                ullage.getTovCub1A(),
                ullage.getTovCub2A(),
                ullage.getTovCub3A(),
                ullage.getTovCub4A());
    }

}
