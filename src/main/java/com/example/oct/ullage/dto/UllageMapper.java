package com.example.oct.ullage.dto;

import com.example.oct.ullage.Ullage;

public class UllageMapper {

    public static CalibrationTableDto ullageToDto(Ullage ullage) {
        return CalibrationTableDto.create(ullage.getName(),
                ullage.getUllage(),
                ullage.getTovCub1F(),
                ullage.getTovCubEk(),
                ullage.getTovCub1A(),
                ullage.getTovCub2A(),
                ullage.getTovCub3A(),
                ullage.getTovCub4A());
    }

    public static UllageDtoShort dtoFullToShor(UllageDtoFull ullageDtoFull) {
        return UllageDtoShort.create(ullageDtoFull.getName(),
                ullageDtoFull.getUllage(),
                ullageDtoFull.getTovCub(),
                ullageDtoFull.getVcf(),
                ullageDtoFull.getGsvBbls(),
                ullageDtoFull.getGsvCub(),
                ullageDtoFull.getMetricTons(),
                ullageDtoFull.getLongTons());
    }

}
