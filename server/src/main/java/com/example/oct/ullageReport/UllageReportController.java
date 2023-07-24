package com.example.oct.ullageReport;

import com.example.oct.enums.Tables;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class UllageReportController {

    private final UllageReportService service;

    @GetMapping("/tank/{tank}")
    public UllageReport create(@PathVariable String tank,
                               @RequestParam String cargo,
                               @RequestParam double ullage,
                               @RequestParam double trim,
                               @RequestParam Tables table) {
        return service.getOneTank(tank, cargo, ullage, trim, table);
    }

}
