package ru.oil.mapper;

import ru.oil.model.Wcf;
import ru.oil.model.dto.WcfDto;

public class WcfMapper {

    public static WcfDto wcfToDto(Wcf wcf) {
        return WcfDto.create(wcf.getT11(), wcf.getT13(), wcf.getT52());
    }

}
