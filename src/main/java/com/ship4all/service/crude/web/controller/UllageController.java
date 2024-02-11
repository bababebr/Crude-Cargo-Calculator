package com.ship4all.service.crude.web.controller;

import com.ship4all.service.crude.service.UllageService;
import com.ship4all.service.crude.model.dto.UllageDto;
import com.ship4all.service.crude.model.dto.UllageRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

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