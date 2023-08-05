package com.example.oct.cargo;

import com.example.oct.cargo.dto.CargoDto;
import com.example.oct.units.api.Api;
import com.example.oct.units.temperature.Temperature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CargoService implements ICargoService {

    private final CargoRepository repository;

    @Autowired
    public CargoService(CargoRepository repository) {
        this.repository = repository;
    }

    @Override
    public CargoDto add(CargoDto cargoDto) {

        if (repository.findByName(cargoDto.getName()).isPresent()) {
            throw new IllegalStateException(String.format("Cargo with Name=%s already exist", cargoDto.getName()));
        }

        Api api = cargoDto.getApi();
        Temperature temperature = cargoDto.getTemperature();

        if (api.getApi() == null) {
            cargoDto.setApi(Api.formDens(api.getDensVac()));
            cargoDto.setTemperature(Temperature.fromCelius(temperature.getCelsius()));
        } else {
            cargoDto.setApi(Api.fromApi(api.getApi()));
            cargoDto.setTemperature(Temperature.fromFahrenheit(temperature.getFahrenheit()));
        }
        repository.save(CargoMapper.dtoToCargo(cargoDto));
        return cargoDto;
    }

    @Override
    public CargoDto update(CargoDto cargoDto, Long id) {
        Optional<Cargo> existedCargo = repository.findById(id);

        if (existedCargo.isEmpty()) {
            throw new IllegalStateException(String.format("Cargo with Name=%s not exist", cargoDto.getName()));
        }

        Cargo cargo = existedCargo.get();
        cargo.setName(cargoDto.getName());
        cargo.setApi(cargoDto.getApi().getApi());
        cargo.setDensity(cargoDto.getApi().getDensVac());
        cargo.setTemp_f(cargoDto.getTemperature().getFahrenheit());
        cargo.setTemp_c(cargoDto.getTemperature().getCelsius());
        cargo.setType(cargoDto.getType());

        return CargoMapper.cargoToDto(repository.save(cargo));
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
