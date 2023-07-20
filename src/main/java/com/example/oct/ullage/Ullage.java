package com.example.oct.ullage;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "calibration_table")
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
