package com.example.oct.cargo;

import com.example.oct.cargo.dto.CargoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICargoService {

    CargoDto add(CargoDto cargoDto, boolean dens);

    List<CargoDto> getAll();

    CargoDto findByName(String name);

    CargoDto get(Long id);

}
