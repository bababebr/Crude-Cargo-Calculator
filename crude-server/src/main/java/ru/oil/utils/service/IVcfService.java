package ru.oil.utils.service;

import ru.oil.enums.Tables;
import ru.oil.utils.model.VcfDto;

public interface IVcfService {

    VcfDto getVcf(double api, double temperature, Tables table, boolean isApi, boolean isCelsius);

}
