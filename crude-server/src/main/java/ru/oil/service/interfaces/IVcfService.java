package ru.oil.service.interfaces;

import ru.oil.enums.Tables;
import ru.oil.model.dto.VcfDto;

public interface IVcfService {

    VcfDto getVcf(double api, double temperature, Tables table, boolean isApi, boolean isCelsius);

}
