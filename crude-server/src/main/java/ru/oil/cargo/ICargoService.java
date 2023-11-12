package ru.oil.cargo;

import ru.oil.cargo.dto.CargoDto;
import org.springframework.stereotype.Service;
import ru.oil.enums.CargoType;

import java.util.List;

@Service
public interface ICargoService {

    CargoDto add(CargoDto cargoDto);

    List<CargoDto> getAll(CargoType type);

    CargoDto getByName(String name);

    CargoDto get(Long id);

    CargoDto update(CargoDto cargoDto, Long id);
}
