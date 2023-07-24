package com.example.oct.ullage;

import com.example.oct.ullage.dto.UllageDto;

public interface IUllageService {

    UllageDto getByUllageAndTank(double ullage, String name);

}
