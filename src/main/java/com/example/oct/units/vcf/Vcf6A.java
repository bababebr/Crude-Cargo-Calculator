package com.example.oct.units.vcf;

import com.example.oct.units.Api;
import com.example.oct.units.Temperature;
import lombok.Data;

@Data
public class Vcf6A {
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
        vcf = calcVcf();
    }

    private double calcA() {
        return 341.0957d / Math.pow((141.5 * 999.012 / (api.getApi() + 131.5)), 2);
    }

    private double calcB() {
        return 1 + 0.8d * a * (temperature.getFahrenheit() - 60);
    }

    private double calcVcf() {
        return Math.exp(a * (temperature.getFahrenheit() - 60) * b * -1);
    }

    public static void main(String[] args) {
        Vcf6A vcf6A = new Vcf6A(Api.fromApi(29.6), Temperature.fromCelius(12.78));
        System.out.println(vcf6A.a);
        System.out.println(vcf6A.b);
        System.out.println(vcf6A.getVcf());
    }
}
