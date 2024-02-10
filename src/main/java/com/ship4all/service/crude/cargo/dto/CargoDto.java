package com.ship4all.service.crude.cargo.dto;

import com.ship4all.service.crude.enums.CargoType;
import com.ship4all.service.crude.model.dto.ApiDto;
import com.ship4all.service.crude.model.dto.TemperatureDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor(staticName = "create")
public class CargoDto {
    @NotNull(value = "Cargo name cannot be null")
    final String name;
    @NotNull(value = "Cargo type cannot be null")
    final CargoType type;
    ApiDto api;
    TemperatureDto temperature;
}
