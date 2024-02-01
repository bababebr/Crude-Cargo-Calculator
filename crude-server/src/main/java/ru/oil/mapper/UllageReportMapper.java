package ru.oil.mapper;

import ru.oil.model.UllageReport;
import ru.oil.model.dto.UllageReportDto;

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
