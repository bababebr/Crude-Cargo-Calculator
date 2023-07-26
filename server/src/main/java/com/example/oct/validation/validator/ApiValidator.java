package com.example.oct.validation.validator;

import com.example.oct.validation.annotation.Api;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ApiValidator implements ConstraintValidator<Api, com.example.oct.units.api.Api> {
    @Override
    public boolean isValid(com.example.oct.units.api.Api api, ConstraintValidatorContext constraintValidatorContext) {
        if(Math.abs(api.getApi()) < 0.001 ){
            api = com.example.oct.units.api.Api.formDens(api.getDensVac());
        }
        else {
            api = com.example.oct.units.api.Api.fromApi(api.getApi());
        }
        return true;
    }
}
