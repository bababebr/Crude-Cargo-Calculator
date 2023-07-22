package com.example.oct.cargo;

import com.example.oct.enums.CargoType;
import com.example.oct.units.api.Api;
import com.example.oct.units.temperature.Temperature;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "CARGO")
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
