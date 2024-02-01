package ru.oil.service;

import org.springframework.stereotype.Service;
import ru.oil.service.interfaces.IWcfService;
import ru.oil.model.Api;
import ru.oil.model.Wcf;
import ru.oil.mapper.WcfMapper;
import ru.oil.model.dto.WcfDto;

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
