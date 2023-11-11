package ru.oil.utils.service;

import org.springframework.stereotype.Service;
import ru.oil.units.api.Api;
import ru.oil.units.wcf.Wcf;
import ru.oil.utils.mapper.WcfMapper;
import ru.oil.utils.model.WcfDto;

@Service
public class WcfService implements IWcfService {

    @Override
    public WcfDto getWcf(double api) {
        return WcfMapper.wcfToDto(Wcf.create(api));
    }

    @Override
    public WcfDto getWcfByDensity(double density) {
        double api = Api.formDens(density).getApi();
        return WcfMapper.wcfToDto(Wcf.create(api));
    }
}
