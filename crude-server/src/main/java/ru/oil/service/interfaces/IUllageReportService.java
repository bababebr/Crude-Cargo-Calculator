package ru.oil.service.interfaces;

import ru.oil.model.dto.UllageRequestDto;
import ru.oil.model.dto.UllageReportDto;

import java.util.List;

public interface IUllageReportService {

    List<UllageReportDto> getReport(List<UllageRequestDto> requestsDto, String cargoName);
}
