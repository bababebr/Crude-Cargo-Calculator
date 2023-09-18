package ru.oil.ullageReport;

import ru.oil.ullage.dto.UllageRequestDto;

import java.util.List;

public interface IUllageReportService {

    List<UllageReport> getReport(List<UllageRequestDto> requestsDto, String cargoName);
}
