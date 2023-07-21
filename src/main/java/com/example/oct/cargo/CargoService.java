package com.example.oct.cargo;

import com.example.oct.cargo.dto.CargoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CargoService implements ICargoService {

    @Autowired
    private final CargoRepository repository;
    @Override
    public CargoDto add(CargoDto cargoDto, boolean dens) {
        CargoDto dto = CargoDto.setUp(cargoDto, dens);
        repository.save(CargoMapper.dtoToCargo(dto));
        return dto;
    }

    @Override
    public List<CargoDto> getAll() {
        return repository.findAll().stream().map(c -> CargoMapper.cargoToDto(c)).collect(Collectors.toList());
    }

    @Override
    public CargoDto get(Long id) {
        return null;
    }
}
