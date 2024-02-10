package com.ship4all.service.crude.mapper;

import com.ship4all.service.crude.model.UllageReport;
import com.ship4all.service.crude.model.dto.UllageReportDto;

public class UllageReportMapper {

    public static UllageReportDto ullageReportToDto(UllageReport report) {
        return UllageReportDto.create(report.getTankName(),
                report.getUllage().getUllage(),
                report.getUllage().getGovBbls(),
                report.getUllage().getGsvBbls(),
                report.getUllage().getMetricTons(),
                report.getUllage().getLongTons(),
                report.getUllage().getApi().getApi(),
                report.getUllage().getTemperature().getFahrenheit(),
                report.getUllage().getVcf());
    }

}
