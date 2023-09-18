package ru.oil.units.temperature;

import lombok.*;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@AllArgsConstructor(staticName = "create")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TemperatureDto {
    Double celsius;
    Double fahrenheit;

    public Temperature toTemperature() {
        if(celsius == null) {
            return Temperature.fromFahrenheit(fahrenheit);
        } else {
            return Temperature.fromCelius(celsius);
        }
    }
}
