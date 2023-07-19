package com.example.oct.ullage.ullageReport;

import com.example.oct.units.api.Api;
import com.example.oct.units.temperature.Temperature;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UllageReport {

    String name;
    Api api;
    Temperature temperature;
    double ullage;
    double tov;
    double gov;
    double gsv;
    double mt;
    double lt;

}
