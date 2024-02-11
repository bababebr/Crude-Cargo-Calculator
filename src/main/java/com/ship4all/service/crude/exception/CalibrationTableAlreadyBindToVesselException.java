package com.ship4all.service.crude.exception;

import java.util.UUID;

public class CalibrationTableAlreadyBindToVesselException extends RuntimeException{

  private final static String EXCEPTION_MESSAGE = "Vessel - %s already has calibration table";

  public CalibrationTableAlreadyBindToVesselException(UUID vesselId) {
    super(String.format(EXCEPTION_MESSAGE, vesselId));
  }
}
