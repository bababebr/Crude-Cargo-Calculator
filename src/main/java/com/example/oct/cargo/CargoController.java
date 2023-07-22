package com.example.oct.cargo;

import com.example.oct.cargo.dto.CargoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargo")
@RequiredArgsConstructor
public class CargoController {

    private final ICargoService cargoService;

    @PostMapping
    public CargoDto add(@Validated @RequestBody CargoDto cargoDto,
                        @RequestParam boolean dens) {
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
