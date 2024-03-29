package com.ship4all.service.crude.exception.handler;

import com.ship4all.service.crude.exception.CalibrationTableAlreadyBindToVesselException;
import jakarta.servlet.ServletException;
import jakarta.validation.ValidationException;
import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse elementNotFoundException(final RuntimeException e) {
        return new ErrorResponse("Element Exception: ", e.getMessage());
    }

    @ExceptionHandler({IllegalStateException.class, ValidationException.class, IllegalArgumentException.class, CalibrationTableAlreadyBindToVesselException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse stateException(final RuntimeException e) {
        return new ErrorResponse("Request Exception: ", e.getMessage());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse requestParamException(final ServletException e) {
        return new ErrorResponse("Request Parameter Error.", e.getMessage());
    }

}