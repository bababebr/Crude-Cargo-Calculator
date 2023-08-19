package ru.oil.ullage.dto;

import ru.oil.units.api.Api;
import ru.oil.units.temperature.Temperature;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor(staticName = "create")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UllageDtoFull {

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
