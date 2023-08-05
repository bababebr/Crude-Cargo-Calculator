package com.example.oct.ullage;

import com.example.oct.ullage.dto.UllageDto;
import com.example.oct.ullage.dto.UllageRequestDto;

public interface IUllageService {

    UllageDto getTankUllage(UllageRequestDto requestDto);

}
