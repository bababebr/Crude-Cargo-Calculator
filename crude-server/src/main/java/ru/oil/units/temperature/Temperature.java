package ru.oil.units.temperature;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Temperature {

    Double celsius;
    Double fahrenheit;

    public static Temperature fromCelsius(double celsius) {
        Temperature t = new Temperature();
        t.setCelsius(celsius);
        t.setFahrenheit(t.toF(celsius));
        return t;
    }

    public static Temperature fromFahrenheit(double fahrenheit) {
        Temperature t = new Temperature();
        t.setFahrenheit(fahrenheit);
        t.setCelsius(t.toC(fahrenheit));
        return t;
    }

    private double toF(double celsius) {
        return (celsius * 9d / 5d) + 32;
    }

    private double toC(double fahrenheit) {
        return (fahrenheit - 32) * 5d / 9d;
    }
}
