package com.example.oct.ullage.dto;

import com.example.oct.ullage.Ullage;

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
