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
    double vol1F;
    double volEK;
    double vol1A;
    double vol2A;
    double vol3A;
    double vol4A;

}
