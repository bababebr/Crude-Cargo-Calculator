package units.vcf;

import lombok.Data;
import units.Api;
import units.Temperature;

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
}
