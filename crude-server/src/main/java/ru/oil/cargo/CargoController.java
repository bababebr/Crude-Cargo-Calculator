package ru.oil.cargo;

import ru.oil.cargo.dto.CargoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cargo")
@RequiredArgsConstructor
public class CargoController {

    private final ICargoService cargoService;

    @PostMapping
    public CargoDto add(@Valid @RequestBody CargoDto cargoDto) {
        return cargoService.add(cargoDto);
    }

    @GetMapping("/all")
    public List<CargoDto> getAll() {
        return cargoService.getAll();
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
