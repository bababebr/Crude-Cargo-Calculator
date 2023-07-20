package com.example.oct.ullage.dto;

import com.example.oct.units.api.Api;
import com.example.oct.units.temperature.Temperature;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Getter
@Setter
@AllArgsConstructor(staticName = "create")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UllageDtoShort {

    String name;
    Double ullage;
    Api api;
    Temperature temperature;
    Double tovCub;
    Double tovBbls;
    Double govCub;
    Double govBbls;
    Double gsvCub;
    Double gsvBbls;
    Double longTons;
    Double metricTons;
    Double vcf;
}
