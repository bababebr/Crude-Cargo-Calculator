package ru.oil.web.controller;

import ru.oil.service.UllageReportService;
import ru.oil.model.dto.UllageRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.oil.model.dto.UllageReportDto;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class UllageReportController {

    private final UllageReportService service;

    @GetMapping("/tank")
    public List<UllageReportDto> create(@Valid @RequestBody List<UllageRequestDto> requestDto, @RequestHeader("Cargo-Name") String cargoName) {
        return service.getReport(requestDto, cargoName);
    }
}
