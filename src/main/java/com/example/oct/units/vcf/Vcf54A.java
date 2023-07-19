package com.example.oct.units.vcf;

import com.example.oct.units.api.Api;
import com.example.oct.units.temperature.Temperature;
import lombok.Data;

@Data
public class Vcf54A implements Vcf {
    final private Api api;
    final private Temperature temperature;

    private double a;
    private double b;
    private double vcf;

    private Vcf54A(Api api, Temperature t) {
        this.api = api;
        this.temperature = t;
        a = calcA();
        b = calcB();
        vcf = this.getVcf();
    }

    public static Vcf54A create(Api api, Temperature temperature) {
        return new Vcf54A(api, temperature);
    }

    public double getVcf() {
        return Math.exp(a * (temperature.getCelsius() - 15) * b * -1);
    }

    public Api getApi() {
        return api;
    }
    public Temperature getTemp() {
        return temperature;
    }

    private double calcA() {
        return 613.9723d / Math.pow(api.getSpecificGravity() * 1000, 2);
    }

    private double calcB() {
        return 1 + 0.8d * a * (temperature.getCelsius() - 15);
    }

}
