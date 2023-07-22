package com.example.oct.cargo;

import com.example.oct.cargo.dto.CargoDto;

public class CargoMapper {

    public static Cargo dtoToCargo(CargoDto dto) {
        Cargo cargo = new Cargo();
        cargo.setName(dto.getName());
        cargo.setType(dto.getType());
        cargo.setApi(dto.getApi());
        cargo.setDensity(dto.getDensity());
        cargo.setTemp_c(dto.getTemp_c());
        cargo.setTemp_f(dto.getTemp_f());
        return cargo;
    }

    public static CargoDto cargoToDto(Cargo cargo) {
        CargoDto dto = CargoDto.create(cargo.getName(), cargo.getType());
        dto.setApi(cargo.getApi());
        dto.setDensity(cargo.getDensity());
        dto.setTemp_c(cargo.getTemp_c());
        dto.setTemp_f(cargo.getTemp_f());
        return dto;
    }
}
