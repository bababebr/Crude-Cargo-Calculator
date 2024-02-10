package com.ship4all.service.crude.service;

import org.springframework.stereotype.Service;
import com.ship4all.service.crude.service.interfaces.IWcfService;
import com.ship4all.service.crude.model.Api;
import com.ship4all.service.crude.model.Wcf;
import com.ship4all.service.crude.mapper.WcfMapper;
import com.ship4all.service.crude.model.dto.WcfDto;

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
