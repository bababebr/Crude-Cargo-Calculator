package com.example.oct.units.vcf;

import com.example.oct.units.Api;
import com.example.oct.units.Temperature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConstructorBinding;

@Data
public class Vcf6A implements Vcf {
    private Api api;
    private Temperature temperature;

    private double a;
    private double b;
    private double vcf;

    public Vcf6A(Api api, Temperature t) {
        this.api = api;
        this.temperature = t;
        a = calcA();
        b = calcB();
        vcf = this.getVcf();
    }

    public static Vcf6A create(Api api, Temperature temperature) {
        return new Vcf6A(api, temperature);
    }

    public double getVcf() {
        return Math.exp(a * (temperature.getFahrenheit() - 60) * b * -1);
    }

    public Api getApi() {
        return api;
    }

    public Temperature getTemp() {
        return temperature;
    }

    private double calcA() {
        return 341.0957d / Math.pow((141.5 * 999.012 / (api.getApi() + 131.5)), 2);
    }

    private double calcB() {
        return 1 + 0.8d * a * (temperature.getFahrenheit() - 60);
    }
}
