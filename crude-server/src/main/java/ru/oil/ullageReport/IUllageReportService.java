package ru.oil.ullageReport;

import ru.oil.ullage.dto.UllageRequestDto;

import java.util.List;

public interface IUllageReportService {

    UllageReport getReport(List<UllageRequestDto> requestsDto, String cargoName);
}
