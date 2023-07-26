package com.example.oct.validation.annotation;

import com.example.oct.validation.validator.ApiValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ApiValidator.class)
@Documented
public @interface Api {
    String message() default "{Api.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
