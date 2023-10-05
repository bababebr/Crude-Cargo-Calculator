package ru.oil.ullageReport;

import ru.oil.ullage.dto.UllageRequestDto;
import ru.oil.ullageReport.model.UllageReportDto;

import java.util.List;

public interface IUllageReportService {

    List<UllageReportDto> getReport(List<UllageRequestDto> requestsDto, String cargoName);
}
