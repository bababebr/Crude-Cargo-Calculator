package com.example.oct.ullage;

import com.example.oct.ullage.dto.UllageDto;

import java.util.List;

public interface IUllageService {

    UllageDto getById(Long id);

    UllageDto getUll(double ullage, String name);


}
