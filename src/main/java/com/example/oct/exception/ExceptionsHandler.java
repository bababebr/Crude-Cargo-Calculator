package com.example.oct.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler({NoSuchElementException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse elementNotFoundException(final RuntimeException e) {
        return new ErrorResponse("Element Exception: ", e.getMessage());
    }

    @ExceptionHandler({IllegalStateException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse stateException(final RuntimeException e) {
        return new ErrorResponse("Request Exception: ", e.getMessage());
    }

}