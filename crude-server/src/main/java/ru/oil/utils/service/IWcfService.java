package ru.oil.utils.service;

import ru.oil.units.api.Api;
import ru.oil.units.wcf.Wcf;
import ru.oil.utils.model.WcfDto;

public interface IWcfService {

    WcfDto getWcf(double api);

    WcfDto getWcfByDensity(double density);
}
