package ru.oil.utils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.oil.enums.Tables;
import ru.oil.utils.model.VcfDto;

@RestController
@RequestMapping("/utils")
public class UtilsController {

    @GetMapping("/vcf")
    public VcfDto getVcf(@PathVariable Tables table) {
        return
    }
}
