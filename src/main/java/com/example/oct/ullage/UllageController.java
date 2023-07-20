package com.example.oct.ullage;

import com.example.oct.enums.Tables;
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

    @GetMapping("tank/{name}")
    public UllageDtoShort getWithTrim(@PathVariable String name,
                                      @RequestParam double ullage,
                                      @RequestParam(required = false, defaultValue = "0") double trim,
                                      @RequestParam double api,
                                      @RequestParam double temp,
                                      @RequestParam Tables table) {
        return service.getUllage(service.getUllageInfo(ullage, name), trim, api, temp, table);
    }


}
