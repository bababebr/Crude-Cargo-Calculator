package com.ship4all.service.crude.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Vessel {

  @Id
  private UUID id;
  private String name;
}