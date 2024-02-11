package com.ship4all.service.crude.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "calibrationTable")
public class CalibrationTable {

  @Id
  Integer id;
}
