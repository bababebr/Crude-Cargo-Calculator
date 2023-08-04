package com.example.oct.cargo;

import com.example.oct.cargo.dto.CargoDto;
import com.example.oct.units.api.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CargoService implements ICargoService {

    private final CargoRepository repository;

    @Autowired
    public CargoService(CargoRepository repository) {
        this.repository = repository;
    }

    @Override
    public CargoDto add(CargoDto cargoDto, boolean dens) {
        repository.save(CargoMapper.dtoToCargo(cargoDto));
        return cargoDto;
    }

    @Override
    public List<CargoDto> getAll() {
        return repository.findAll().stream().map(CargoMapper::cargoToDto).collect(Collectors.toList());
    }

    @Override
    public CargoDto getByName(String name) {
        return CargoMapper.cargoToDto(repository.findByName(name).orElseThrow(
                () -> new NoSuchElementException("Cargo with NAME=" + name + " not found.")));
    }

    @Override
    public CargoDto get(Long id) {
        return CargoMapper.cargoToDto(repository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Cargo with ID=" + id + " not found.")));
    }



}
