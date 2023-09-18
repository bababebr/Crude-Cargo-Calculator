package ru.oil.cargo.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.oil.enums.CargoType;
import ru.oil.units.api.ApiDto;
import ru.oil.units.temperature.TemperatureDto;

import javax.validation.constraints.NotNull;
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor(staticName = "create")
public class CargoDto {
    @NotNull(message = "Cargo name cannot be null")
    final String name;
    @NotNull(message = "Cargo type cannot be null")
    final CargoType type;
    ApiDto api;
    TemperatureDto temperature;
}
