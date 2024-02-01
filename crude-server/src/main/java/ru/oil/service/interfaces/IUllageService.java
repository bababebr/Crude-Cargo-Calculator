package ru.oil.service.interfaces;

import ru.oil.model.dto.UllageDto;
import ru.oil.model.dto.UllageRequestDto;

public interface IUllageService {

    UllageDto getTankUllage(UllageRequestDto requestDto);

}
