package com.example.oct.ullage;

import com.example.oct.ullage.dto.UllageDto;
import com.example.oct.ullage.dto.UllageRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/ullage")
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
