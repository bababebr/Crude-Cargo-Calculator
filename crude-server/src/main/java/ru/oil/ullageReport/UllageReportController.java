package ru.oil.ullageReport;

import ru.oil.ullage.dto.UllageRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.oil.ullageReport.model.UllageReportDto;

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
