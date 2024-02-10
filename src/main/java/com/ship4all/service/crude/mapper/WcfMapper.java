package com.ship4all.service.crude.mapper;

import com.ship4all.service.crude.model.Wcf;
import com.ship4all.service.crude.model.dto.WcfDto;

public class WcfMapper {

    public static WcfDto wcfToDto(Wcf wcf) {
        return WcfDto.create(wcf.getT11(), wcf.getT13(), wcf.getT52());
    }

}
