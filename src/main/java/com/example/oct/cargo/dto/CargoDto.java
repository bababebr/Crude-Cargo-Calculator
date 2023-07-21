package com.example.oct.cargo.dto;

import com.example.oct.enums.CargoType;
import com.example.oct.units.api.Api;
import com.example.oct.units.temperature.Temperature;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * TODO  CargoDto validation apiOfDens or Temp_C/Temp_f equals null
 */
@Validated
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor(staticName = "create")
public class CargoDto {

    @NotNull
    final String name;
    @NotNull
    final CargoType type;
    Double api;
    Double density;
    Double temp_f;
    Double temp_c;

    public static CargoDto setUp(CargoDto cargoDto, boolean densCelc) {
        Api api1;
        Temperature t;
        if(densCelc) {
            api1 = Api.formDens(cargoDto.density);
            t = Temperature.fromCelius(cargoDto.temp_c);
            cargoDto.setApi(api1.getApi());
            cargoDto.setTemp_f(t.getFahrenheit());
        } else {
            api1 = Api.fromApi(cargoDto.api);
            t = Temperature.fromFahrenheit(cargoDto.temp_f);
            cargoDto.setDensity(api1.getDensVac());
            cargoDto.setTemp_c(t.getCelsius());
        }
        return cargoDto;
    }

}
