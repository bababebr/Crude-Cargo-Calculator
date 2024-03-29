package com.ship4all.service.crude.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "create")
public class Wcf {

    private double api;

    public double getT11() {
        return (0.0375 * ((589.943 / (api + 131.5)) - 0.0050789) * 100000 + 0.5) / 100000;
    }

    public double getT13() {
        return (0.042 * ((535.1911 / (api + 131.5)) - 0.0046189) * 100000 + 0.5) / 100000;
    }

    public double getT52() {
        double t52 = 0.15893;
        if (api <= 15.29) {
            return t52;
        } else if (api < 33.19) {
            return t52 - 0.00001;
        } else if (api < 45.59) {
            return t52 - 0.00002;
        } else if (api < 49.89) {
            return t52 - 0.00003;
        } else if (api < 52.69) {
            return t52 - 0.00004;
        } else if (api < 64.39) {
            return t52 - 0.00005;
        } else if (api < 75.59) {
            return t52 - 0.00006;
        }
        return 0;
    }

}
