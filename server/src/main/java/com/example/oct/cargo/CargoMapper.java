package com.example.oct.cargo;

import com.example.oct.cargo.dto.CargoDto;
import com.example.oct.units.api.Api;
import com.example.oct.units.temperature.Temperature;

public class CargoMapper {

    public static Cargo dtoToCargo(CargoDto dto) {
        Cargo cargo = new Cargo();
        cargo.setName(dto.getName());
        cargo.setType(dto.getType());
        cargo.setApi(dto.getApi().getApi());
        cargo.setDensity(dto.getApi().getDensVac());
        cargo.setTemp_f(dto.getTemperature().getFahrenheit());
        cargo.setTemp_c(dto.getTemperature().getCelsius());
        return cargo;
    }

    public static CargoDto cargoToDto(Cargo cargo) {
        CargoDto dto = CargoDto.create(cargo.getName(), cargo.getType());
        dto.setApi(Api.fromApi(cargo.getApi()));
        dto.setTemperature(Temperature.fromFahrenheit(cargo.getTemp_f()));
        return dto;
    }
}
