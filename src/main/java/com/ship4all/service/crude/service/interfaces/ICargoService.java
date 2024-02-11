package com.ship4all.service.crude.service.interfaces;

import com.ship4all.service.crude.model.dto.CargoDto;
import java.util.UUID;
import org.springframework.stereotype.Service;
import com.ship4all.service.crude.enums.CargoType;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface ICargoService {

    CargoDto add(CargoDto cargoDto);

    List<CargoDto> getAll(CargoType type);

    CargoDto getByName(String name);

    CargoDto get(Long id);

    CargoDto update(CargoDto cargoDto, Long id);

    long bingCargoTanks(MultipartFile file, UUID vesselId);
}
