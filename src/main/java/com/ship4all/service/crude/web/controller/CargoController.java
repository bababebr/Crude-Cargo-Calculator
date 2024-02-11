package com.ship4all.service.crude.web.controller;

import com.ship4all.service.crude.model.dto.CargoDto;
import com.ship4all.service.crude.service.interfaces.ICargoService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.ship4all.service.crude.enums.CargoType;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/cargo")
public class CargoController {

    private final ICargoService cargoService;

    @Autowired
    public CargoController(ICargoService cargoService) {
        this.cargoService = cargoService;
    }

    @PostMapping(value = "/{vesselId}/bind", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Long bindCargoTanks(@RequestParam("file") MultipartFile file, @PathVariable UUID vesselId) {
        return cargoService.bingCargoTanks(file, vesselId);
    }

    @PostMapping
    public CargoDto add(@Valid @RequestBody CargoDto cargoDto) {
        return cargoService.add(cargoDto);
    }

    @GetMapping("/all")
    public List<CargoDto> getAll(@RequestParam(required = false) CargoType type) {
        return cargoService.getAll(type);
    }

    @PutMapping("/update")
    public CargoDto update(@Valid @RequestBody CargoDto cargoDto, @RequestHeader("Cargo-Id") Long id) {
        return cargoService.update(cargoDto, id);
    }

    @GetMapping("/{id}")
    public CargoDto get(@PathVariable Long id) {
        return cargoService.get(id);
    }

}
