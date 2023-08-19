package ru.oil.ullage;

import ru.oil.ullage.dto.UllageDto;
import ru.oil.ullage.dto.UllageRequestDto;

public interface IUllageService {

    UllageDto getTankUllage(UllageRequestDto requestDto);

}
