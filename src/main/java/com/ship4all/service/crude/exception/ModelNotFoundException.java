package com.ship4all.service.crude.exception;

public class ModelNotFoundException extends RuntimeException {

  private static final String EXCEPTION_MESSAGE = "Entity - %s not found";

  public ModelNotFoundException(String entityName) {
    super(String.format(EXCEPTION_MESSAGE, entityName));
  }
}
