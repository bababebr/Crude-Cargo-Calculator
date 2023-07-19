package com.example.oct.ullage.dto;

import com.example.oct.ullage.Ullage;

public class UllageMapper {

    public static UllageDto ullageToDto(Ullage ullage) {
        return UllageDto.create(ullage.getName(),
                ullage.getUllage(),
                ullage.getVol1F(),
                ullage.getVolEK(),
                ullage.getVol1A(),
                ullage.getVol2A(),
                ullage.getVol3A(),
                ullage.getVol4A());
    }

}
