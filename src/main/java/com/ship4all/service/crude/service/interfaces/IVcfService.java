package com.ship4all.service.crude.service.interfaces;

import com.ship4all.service.crude.enums.Tables;
import com.ship4all.service.crude.model.dto.VcfDto;

public interface IVcfService {

    VcfDto getVcf(double api, double temperature, Tables table, boolean isApi, boolean isCelsius);

}
