package ru.oil.cargo.dto;

import ru.oil.enums.CargoType;
import ru.oil.units.api.Api;
import ru.oil.units.temperature.Temperature;
import ru.oil.validation.annotaion.Cargo;
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
