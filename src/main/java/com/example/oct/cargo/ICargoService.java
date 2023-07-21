package com.example.oct.cargo;

import com.example.oct.cargo.dto.CargoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICargoService {

    public CargoDto add(CargoDto cargoDto, boolean dens);

    public List<CargoDto> getAll();

    public CargoDto get(Long id);

}
