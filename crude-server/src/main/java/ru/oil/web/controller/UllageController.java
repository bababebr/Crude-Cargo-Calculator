package ru.oil.web.controller;

import ru.oil.service.UllageService;
import ru.oil.model.dto.UllageDto;
import ru.oil.model.dto.UllageRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/ullage")
public class UllageController {

    private final UllageService service;

    @Autowired
    public UllageController(UllageService service) {
        this.service = service;
    }

    @GetMapping("/tank")
    public UllageDto get(@Valid @RequestBody UllageRequestDto requestDto) {
        return service.getTankUllage(requestDto);
    }


}
