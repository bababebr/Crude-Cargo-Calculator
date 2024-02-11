package com.ship4all.service.crude.model;

import com.ship4all.service.crude.enums.CargoType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "cargo")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
public class Cargo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  @Column(name = "name")
  String name;
  @Enumerated(EnumType.STRING)
  CargoType type;
  @Column(name = "api")
  Double api;
  @Column(name = "density")
  Double density;
  @Column(name = "temp_c")
  Double temp_c;
  @Column(name = "temp_f")
  Double temp_f;
}
