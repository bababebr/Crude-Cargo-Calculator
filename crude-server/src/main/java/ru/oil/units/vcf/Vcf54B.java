package ru.oil.units.vcf;

import ru.oil.units.api.Api;
import ru.oil.units.temperature.Temperature;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@ToString
public class Vcf54B implements Vcf {
    Api api;
    Temperature temperature;

    @NonFinal
    double cor1;
    @NonFinal
    double cor2;
    @NonFinal
    double vcf;

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

    public static Vcf54B create(Api api, Temperature t) {
        Vcf54B vcf = new Vcf54B(api, t);
        vcf.setCor1(vcf.cor1());
        vcf.setCor2(vcf.cor2());
        vcf.setVcf(vcf.getVcf54B());
        return vcf;
    }

    private double cor1() {
        double density = api.getDensVac() * 1000;
        if (density < 770) {
            return (192.4571 / (density * density)) + (0.2438 / density);
        } else if (density >= 770 && density < 787.5) {
            return (1489.0671 / (density * density)) - 0.0018684;
        } else if (density >= 787.5 && density < 838.5) {
            return 330.301 / (density * density);
        } else if (density >= 838.5 && density < 1075) {
            return (0.2701 / density) + (103.873 / (density * density));
        } else throw new IllegalStateException("Table 54B: Api cannot be larger than 1.075");
    }

    private double cor2() {
        return ((temperature.getCelsius() + 40) * 1.8) - 99;
    }

    public double getVcf54B() {
        return Math.exp(-1 * cor1 * cor2 * (1 + 0.8 * cor1 * cor2));
    }

}
