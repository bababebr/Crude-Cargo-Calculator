package ru.oil.cargo;

import ru.oil.cargo.dto.CargoDto;
import ru.oil.units.api.Api;
import ru.oil.units.api.ApiDto;
import ru.oil.units.temperature.Temperature;
import ru.oil.units.temperature.TemperatureDto;

public class CargoMapper {

    public static Cargo dtoToCargo(CargoDto dto, Api api, Temperature temperature) {
        Cargo cargo = new Cargo();
        cargo.setName(dto.getName());
        cargo.setType(dto.getType());
        cargo.setApi(api.getApi());
        cargo.setDensity(api.getDensVac());
        cargo.setTemp_f(temperature.getFahrenheit());
        cargo.setTemp_c(temperature.getCelsius());
        return cargo;
    }

    public static CargoDto cargoToDto(Cargo cargo) {
        CargoDto dto = CargoDto.create(cargo.getName(), cargo.getType());
        dto.setApi(ApiDto.create(cargo.getApi(), cargo.getDensity()));
        dto.setTemperature(TemperatureDto.create(cargo.getTemp_c(), cargo.getTemp_f()));
        return dto;
    }
}
