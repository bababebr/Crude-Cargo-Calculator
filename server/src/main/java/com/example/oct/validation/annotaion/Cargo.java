package com.example.oct.validation.annotaion;

import com.example.oct.validation.validator.CargoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = CargoValidator.class)
@Documented
public @interface Cargo {

    String message() default "{CargoDto.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
