package com.ship4all.service.crude.service.interfaces;

import com.ship4all.service.crude.model.dto.WcfDto;

public interface IWcfService {

    WcfDto getWcf(double api);

    WcfDto getWcfByDensity(double density);
}
