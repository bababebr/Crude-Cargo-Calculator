package ru.oil.cargo;

import ru.oil.cargo.dto.CargoDto;
import ru.oil.units.api.Api;
import ru.oil.units.api.ApiDto;
import ru.oil.units.temperature.Temperature;
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
        Api api = cargoDto.getApi().toApi();
        Temperature temperature = cargoDto.getTemperature().toTemperature();
        repository.save(CargoMapper.dtoToCargo(cargoDto, api, temperature));
        return cargoDto;
    }

    @Override
    public CargoDto update(CargoDto cargoDto, Long id) {
        Optional<Cargo> existedCargo = repository.findById(id);
        if (existedCargo.isEmpty()) {
            throw new IllegalStateException(String.format("Cargo with Name=%s not exist", cargoDto.getName()));
        }
        Api newApi = cargoDto.getApi().toApi();
        Temperature newTemperature = cargoDto.getTemperature().toTemperature();

        Cargo cargo = existedCargo.get();
        cargo.setName(cargoDto.getName());
        cargo.setApi(newApi.getApi());
        cargo.setDensity(newApi.getDensVac());
        cargo.setTemp_f(newTemperature.getFahrenheit());
        cargo.setTemp_c(newTemperature.getCelsius());
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
