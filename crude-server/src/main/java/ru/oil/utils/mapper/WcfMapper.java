package ru.oil.utils.mapper;

import ru.oil.units.wcf.Wcf;
import ru.oil.utils.model.WcfDto;

public class WcfMapper {

    public static WcfDto wcfToDto(Wcf wcf) {
        return WcfDto.create(wcf.getT11(), wcf.getT13(), wcf.getT52());
    }

}
