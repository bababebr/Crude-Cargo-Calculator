package ru.oil.units.vcf;

import ru.oil.units.api.Api;
import ru.oil.units.temperature.Temperature;

public interface Vcf {
    double getVcf();
    Api getApi();
    Temperature getTemp();
}
