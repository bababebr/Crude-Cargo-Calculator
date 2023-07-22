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

    public static Cargo fromApi(String name, CargoType type, double api, double temp_f) {
        Api api1 = Api.fromApi(api);
        Temperature t = Temperature.fromFahrenheit(temp_f);
        Cargo cargo = new Cargo();
        cargo.setName(name);
        cargo.setType(type);
        cargo.setApi(api);
        cargo.setTemp_f(temp_f);
        cargo.setDensity(api1.getDensVac());
        cargo.setTemp_c(t.getCelsius());
        return cargo;
    }

    public static Cargo fromDensity(String name, CargoType type, double density, double temp_c) {
        Api api1 = Api.formDens(density);
        Temperature t = Temperature.fromCelius(temp_c);
        Cargo cargo = new Cargo();
        cargo.setName(name);
        cargo.setType(type);
        cargo.setDensity(density);
        cargo.setTemp_c(temp_c);
        cargo.setDensity(api1.getApi());
        cargo.setTemp_c(t.getFahrenheit());
        return cargo;
    }
}
