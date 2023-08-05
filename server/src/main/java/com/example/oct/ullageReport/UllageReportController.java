package com.example.oct.ullageReport;

import com.example.oct.enums.Tables;
import com.example.oct.ullage.dto.UllageRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class UllageReportController {

    private final UllageReportService service;

    @GetMapping("/tank")
    public UllageReport create(@Valid @RequestBody UllageRequestDto requestDto, @RequestHeader("Cargo-Name") String cargoName) {
        return service.getOneTank(requestDto, cargoName);
    }

}
