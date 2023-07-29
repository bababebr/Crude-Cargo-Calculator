package com.example.oct.cargo;

import com.example.oct.cargo.dto.CargoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public CargoDto add(@Validated @RequestBody CargoDto cargoDto,
                        @RequestParam boolean dens) {
        System.out.println(cargoDto.getApi());
        return cargoService.add(cargoDto, dens);
    }

    @GetMapping("/all")
    public List<CargoDto> getAll() {
        return cargoService.getAll();
    }

    @GetMapping("/{id}")
    public CargoDto get(@PathVariable Long id) {
        return cargoService.get(id);
    }

}
