package com.ship4all.service.crude.cargo;

import com.ship4all.service.crude.cargo.dto.CargoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ship4all.service.crude.enums.CargoType;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cargo")
public class CargoController {

    private final ICargoService cargoService;

    @Autowired
    public CargoController(ICargoService cargoService) {
        this.cargoService = cargoService;
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
