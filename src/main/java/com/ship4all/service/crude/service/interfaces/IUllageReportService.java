package com.ship4all.service.crude.service.interfaces;

import com.ship4all.service.crude.model.dto.UllageRequestDto;
import com.ship4all.service.crude.model.dto.UllageReportDto;

import java.util.List;

public interface IUllageReportService {

    List<UllageReportDto> getReport(List<UllageRequestDto> requestsDto, String cargoName);
}
