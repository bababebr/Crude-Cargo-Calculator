package com.example.oct.cargo.dto;

import com.example.oct.enums.CargoType;
import com.example.oct.units.api.Api;
import com.example.oct.units.temperature.Temperature;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
@Validated
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor(staticName = "create")
public class CargoDto {

    /**
     * TODO change API & TEMPERATURE from Double to Api and temp Objects
     */

    @NotNull
    final String name;
    @NotNull
    final CargoType type;
    @NotNull
    Api api;
    @NotNull
    Temperature temperature;

}