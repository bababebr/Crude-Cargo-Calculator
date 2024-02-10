package com.ship4all.service.crude.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "CalibrationTable")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Ullage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "tank")
    String name;
    Double ullage;
    @Column(name = "CUB1F")
    Double TovCub1F;
    @Column(name = "CUB")
    Double TovCubEk;
    @Column(name = "CUB1A")
    Double TovCub1A;
    @Column(name = "CUB2A")
    Double TovCub2A;
    @Column(name = "CUB3A")
    Double TovCub3A;
    @Column(name = "CUB4A")
    Double TovCub4A;

}
