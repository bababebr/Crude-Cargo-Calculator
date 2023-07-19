package com.example.oct.ullage;

import com.example.oct.ullage.dto.UllageDto;
import com.example.oct.ullage.dto.UllageDtoShort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ullage")
public class UllageController {

    private final UllageService service;

    @Autowired
    public UllageController(UllageService service) {
        this.service = service;
    }

    @GetMapping()
    public UllageDto getUll(@RequestParam double ullage, @RequestParam String name) {
        return service.getUllageInfo(ullage, name);
    }

    @GetMapping("/trim")
    public UllageDtoShort getWithTrim(@RequestParam double ullage, @RequestParam String name, double trim) {
        return service.getUllage(service.getUllageInfo(ullage, name), trim);
    }


}
