package ru.oil.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.oil.enums.Tables;
import ru.oil.utils.model.VcfDto;
import ru.oil.utils.service.VcfService;

@RestController
@RequestMapping("/utils")
public class UtilsController {

    private final VcfService vcfService;

    @Autowired
    public UtilsController(VcfService vcfService) {
        this.vcfService = vcfService;
    }

    @GetMapping("/vcf")
    public VcfDto getVcf(@RequestParam Double api, @RequestParam Double temp, @RequestParam Tables table,
                         @RequestHeader("Is-Api") boolean isApi, @RequestHeader("Is-Celsius") boolean isCelsius) {
        return vcfService.getVcf(api, temp, table, isApi, isCelsius);
    }
}
