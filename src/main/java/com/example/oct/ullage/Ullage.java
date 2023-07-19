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
    Double vol1F;
    @Column(name = "CUB")
    Double volEK;
    @Column(name = "CUB1A")
    Double vol1A;
    @Column(name = "CUB2A")
    Double vol2A;
    @Column(name = "CUB3A")
    Double vol3A;
    @Column(name = "CUB4A")
    Double vol4A;

}
