package ru.oil.units.temperature;

import lombok.Data;

@Data
public class Temperature {

    private Double celsius;
    private Double fahrenheit;

    public static Temperature fromCelius(double celsius) {
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
