package com.example.oct.ullage.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor(staticName = "create")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Getter
@Setter
public class UllageDto {

    String name;
    double ullage;
    double TovCub1F;
    double TovCubEK;
    double TovCub1A;
    double TovCub2A;
    double TovCub3A;
    double TovCub4A;

}
