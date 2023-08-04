package com.example.oct.cargo.dto;

import com.example.oct.enums.CargoType;
import com.example.oct.units.api.Api;
import com.example.oct.units.temperature.Temperature;
import com.example.oct.validation.annotaion.Cargo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor(staticName = "create")
@Cargo(message = "Cargo must contains pairs of API and fahrenheit or Density vac. and celsius for proper calculations.")
public class CargoDto {
    @NotNull(message = "Cargo name cannot be null")
    final String name;
    @NotNull(message = "Cargo type cannot be null")
    final CargoType type;
    Api api;
    Temperature temperature;
}
