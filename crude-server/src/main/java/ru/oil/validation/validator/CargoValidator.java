package ru.oil.validation.validator;

import ru.oil.cargo.dto.CargoDto;
import ru.oil.validation.annotaion.Cargo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CargoValidator implements ConstraintValidator<Cargo, CargoDto> {

    @Override
    public boolean isValid(CargoDto cargoDto, ConstraintValidatorContext constraintValidatorContext) {
        boolean apiFarh = true;
        boolean densCelc = true;
        try {
            cargoDto.getApi().getApi().equals(null);
            cargoDto.getTemperature().getFahrenheit().equals(null);
        } catch (NullPointerException e) {
            apiFarh = false;
        }
        try {
            cargoDto.getApi().getDensVac().equals(null);
            cargoDto.getTemperature().getCelsius().equals(null);
        } catch (NullPointerException e) {
            densCelc = false;
        }
        return apiFarh || densCelc;
    }
}
