package com.ship4all.service.crude.web.controller;

import com.ship4all.service.crude.service.UllageReportService;
import com.ship4all.service.crude.model.dto.UllageRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.ship4all.service.crude.model.dto.UllageReportDto;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/report")
@RequiredArgsConstructor
public class UllageReportController {

    private final UllageReportService service;

    @GetMapping("/tank")
    public List<UllageReportDto> create(@Valid @RequestBody List<UllageRequestDto> requestDto, @RequestHeader("Cargo-Name") String cargoName) {
        return service.getReport(requestDto, cargoName);
    }
}
