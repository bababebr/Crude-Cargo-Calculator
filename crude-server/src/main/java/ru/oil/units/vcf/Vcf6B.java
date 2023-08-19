package ru.oil.units.vcf;

import ru.oil.units.api.Api;
import ru.oil.units.temperature.Temperature;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Vcf6B implements Vcf {

    private final Api api;
    private final Temperature temperature;

    private double cor1;
    private double cor2;
    private double cor3;
    private double vcf;

    public static Vcf6B create(Api api, Temperature t) {
        Vcf6B vcf6B = new Vcf6B(api, t);
        vcf6B.cor1 = vcf6B.cor1();
        vcf6B.cor2 = vcf6B.cor2();
        vcf6B.cor3 = vcf6B.cor3();
        vcf6B.vcf = vcf6B.vcf();
        return vcf6B;
    }

    @Override
    public double getVcf() {
        return vcf;
    }

    @Override
    public Api getApi() {
        return api;
    }

    @Override
    public Temperature getTemp() {
        return temperature;
    }

    private double cor1() {
        return (141.5 * 999.012) / (api.getApi() + 131.5);
    }

    private double cor2() {
        if (api.getApi() < 37) {
            return (103.872 / (cor1 * cor1)) + (0.2701 / cor1);
        } else if (api.getApi() >= 37 && api.getApi() < 48) {
            return 330.301 / (cor1 * cor1);
        } else if ((api.getApi() >= 48 && api.getApi() < 52)) {
            return ((1489.067 / (cor1 * cor1)) - 0.0018684);
        } else if (api.getApi() >= 52 && api.getApi() < 85) {
            return (192.4571 / (cor1 * cor1)) + (0.2438 / cor1);
        } else throw new IllegalStateException("Table 6B: Api cannot be larger than 85");
    }

    private double cor3() {
        return 1 + 0.8 * cor2 * (temperature.getFahrenheit() - 60);
    }

    private double vcf() {
        return Math.exp(cor2 * (temperature.getFahrenheit() - 60) * cor3 * -1);
    }
}
