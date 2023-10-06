package ru.oil.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.oil.enums.Tables;
import ru.oil.utils.model.VcfDto;
import ru.oil.utils.model.WcfDto;
import ru.oil.utils.service.VcfService;
import ru.oil.utils.service.WcfService;

@RestController
@RequestMapping("/utils")
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
    public WcfDto getWcf(@RequestParam(required = false) Double api) {
        return wcfService.getWcf(api);
    }
}
