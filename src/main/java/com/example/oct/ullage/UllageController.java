package com.example.oct.ullage;

import com.example.oct.ullage.dto.UllageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return service.getUll(ullage, name);
    }

}
