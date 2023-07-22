package com.example.oct.ullage;

import com.example.oct.ullage.dto.UllageDto;

public interface IUllageService {

    UllageDto getById(Long id);

    UllageDto getUllageInfo(double ullage, String name);


}
