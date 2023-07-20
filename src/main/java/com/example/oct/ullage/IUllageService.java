package com.example.oct.ullage;

import com.example.oct.ullage.dto.CalibrationTableDto;

public interface IUllageService {

    CalibrationTableDto getById(Long id);

    CalibrationTableDto getUllageInfo(double ullage, String name);


}
