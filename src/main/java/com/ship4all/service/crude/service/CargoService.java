package com.ship4all.service.crude.service;

import static com.ship4all.service.crude.util.FileUtils.csvToStringArray;
import static com.ship4all.service.crude.util.FileUtils.multiFileToFile;

import com.ship4all.service.crude.enums.CargoType;
import com.ship4all.service.crude.enums.Constants;
import com.ship4all.service.crude.exception.CalibrationTableAlreadyBindToVesselException;
import com.ship4all.service.crude.mapper.CargoMapper;
import com.ship4all.service.crude.model.Api;
import com.ship4all.service.crude.model.Cargo;
import com.ship4all.service.crude.model.Temperature;
import com.ship4all.service.crude.model.dto.CargoDto;
import com.ship4all.service.crude.repository.CalibrationTableRepository;
import com.ship4all.service.crude.repository.CargoRepository;
import com.ship4all.service.crude.service.interfaces.ICargoService;
import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
@RequiredArgsConstructor
public class CargoService implements ICargoService {

  private final CargoRepository cargoRepository;
  private final CalibrationTableRepository calibrationTableRepository;

  @Transactional
  public long bingCargoTanks(MultipartFile multiPartFile, UUID vesselId) {
    log.info("Start binding calibration table to vessel - {}", vesselId);
    if (calibrationTableRepository.vesselHasCalibrationTable(vesselId)) {
      throw new CalibrationTableAlreadyBindToVesselException(vesselId);
    }
    File file = multiFileToFile(multiPartFile, vesselId.toString(), Constants.FILE_EXTENSION_CSV);
    List<String[]> rows = csvToStringArray(file, true);
    for (String[] row : rows) {
      calibrationTableRepository.add(row[1], Double.parseDouble(row[0]), Double.parseDouble(row[2]), Double.parseDouble(row[3]),
          Double.parseDouble(row[4]), Double.parseDouble(row[5]), Double.parseDouble(row[6]), Double.parseDouble(row[7]), vesselId);
    }
    log.info("Calibration table successfully binded to vessel - {}", vesselId);
    return rows.size();
  }

  @Override
  public CargoDto add(CargoDto cargoDto) {
    if (cargoRepository.findByName(cargoDto.getName()).isPresent()) {
      throw new IllegalStateException(String.format("Cargo with Name=%s already exist", cargoDto.getName()));
    }
    Api api = cargoDto.getApi().toApi();
    Temperature temperature = cargoDto.getTemperature().toTemperature();
    cargoRepository.save(CargoMapper.dtoToCargo(cargoDto, api, temperature));
    cargoDto = CargoMapper.cargoToDto(cargoRepository.findByName(cargoDto.getName()).get());
    return cargoDto;
  }

  @Override
  public CargoDto update(CargoDto cargoDto, Long id) {
    Optional<Cargo> existedCargo = cargoRepository.findById(id);
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

    return CargoMapper.cargoToDto(cargoRepository.save(cargo));
  }

  @Override
  public List<CargoDto> getAll(CargoType type) {
    if (type == null) {
      return cargoRepository.findAll().stream().map(CargoMapper::cargoToDto).collect(Collectors.toList());
    } else {
      return cargoRepository.findAllByType(type).stream().map(CargoMapper::cargoToDto).collect(Collectors.toList());
    }
  }

  @Override
  public CargoDto getByName(String name) {
    return CargoMapper.cargoToDto(cargoRepository.findByName(name).orElseThrow(
        () -> new NoSuchElementException("Cargo with NAME=" + name + " not found.")));
  }

  @Override
  public CargoDto get(Long id) {
    return CargoMapper.cargoToDto(cargoRepository.findById(id).orElseThrow(
        () -> new NoSuchElementException("Cargo with ID=" + id + " not found.")));
  }
}