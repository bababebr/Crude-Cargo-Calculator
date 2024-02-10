package com.ship4all.service.crude.service.interfaces;

import com.ship4all.service.crude.model.dto.UllageDto;
import com.ship4all.service.crude.model.dto.UllageRequestDto;

public interface IUllageService {

    UllageDto getTankUllage(UllageRequestDto requestDto);

}
