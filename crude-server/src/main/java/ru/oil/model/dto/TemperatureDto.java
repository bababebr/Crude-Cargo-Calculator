package ru.oil.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.oil.model.Temperature;

@RequiredArgsConstructor
@AllArgsConstructor(staticName = "create")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TemperatureDto {

    Double celsius;
    Double fahrenheit;

    public Temperature toTemperature() {
        if (celsius == null && fahrenheit == null) {
            throw new IllegalArgumentException("You must enter temperature either in celsius or fahrenheit.");
        }
        if (celsius == null) {
            return Temperature.fromFahrenheit(fahrenheit);
        } else {
            return Temperature.fromCelsius(celsius);
        }
    }
}
