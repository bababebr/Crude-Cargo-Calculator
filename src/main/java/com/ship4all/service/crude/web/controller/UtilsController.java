package com.ship4all.service.crude.web.controller;

import com.ship4all.service.crude.service.VcfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ship4all.service.crude.enums.Tables;
import com.ship4all.service.crude.model.dto.VcfDto;
import com.ship4all.service.crude.model.dto.WcfDto;
import com.ship4all.service.crude.service.WcfService;

@RestController
@RequestMapping("api/utils")
public class UtilsController {

    private final VcfService vcfService;
    private final WcfService wcfService;

    @Autowired
    public UtilsController(VcfService vcfService, WcfService wcfService) {
        this.vcfService = vcfService;
        this.wcfService = wcfService;
    }

    @GetMapping("/vcf")
    public VcfDto getVcf(@RequestParam Double api, @RequestParam Double temp, @RequestParam Tables table,
                         @RequestHeader("Is-Api") boolean isApi, @RequestHeader("Is-Celsius") boolean isCelsius) {
        return vcfService.getVcf(api, temp, table, isApi, isCelsius);
    }

    @GetMapping("/wcf")
    public WcfDto getWcf(@RequestParam Double api) {
        return wcfService.getWcf(api);
    }
}
