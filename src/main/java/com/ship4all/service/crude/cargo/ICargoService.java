package com.ship4all.service.crude.cargo;

import com.ship4all.service.crude.cargo.dto.CargoDto;
import org.springframework.stereotype.Service;
import com.ship4all.service.crude.enums.CargoType;

import java.util.List;

@Service
public interface ICargoService {

    CargoDto add(CargoDto cargoDto);

    List<CargoDto> getAll(CargoType type);

    CargoDto getByName(String name);

    CargoDto get(Long id);

    CargoDto update(CargoDto cargoDto, Long id);
}
