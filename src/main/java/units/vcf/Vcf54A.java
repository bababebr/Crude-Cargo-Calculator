package units.vcf;

import lombok.Data;
import units.Api;
import units.Temperature;

@Data
public class Vcf54A {
    private Api api;
    private Temperature temperature;

    private double a;
    private double b;
    private double vcf;

    public Vcf54A(Api api, Temperature t) {
        this.api = api;
        this.temperature = t;
        a = calcA();
        b = calcB();
        vcf = calcVcf();
    }

    private double calcA() {
        return 613.9723d / Math.pow(api.getDensVac()*1000, 2);
    }

    private double calcB() {
        return 1 + 0.8d * a * (temperature.getCelsius() - 15);
    }

    private double calcVcf() {
        return Math.exp(a * (temperature.getFahrenheit() - 15) * b * -1);
    }
}
