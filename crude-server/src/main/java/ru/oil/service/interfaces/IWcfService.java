package ru.oil.service.interfaces;

import ru.oil.model.dto.WcfDto;

public interface IWcfService {

    WcfDto getWcf(double api);

    WcfDto getWcfByDensity(double density);
}
