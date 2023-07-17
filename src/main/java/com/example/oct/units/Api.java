package com.example.oct.units;

import lombok.Data;

@Data
public class Api {

    private double api;
    private double densVac;
    private double densAir;

    public static Api fromApi(double api) {
        Api a = new Api();
        a.setApi(api);
        a.setDensVac(a.toDens(api));
        a.setDensAir(a.getDensVac() - 0.0011);
        return a;
    }

    public static Api formDens(double densVac) {
        Api a = new Api();
        a.setDensVac(densVac);
        a.setApi(a.toApi(densVac));
        a.setDensAir(a.getDensVac() - 0.0011);
        return a;
    }

    private double toApi(double dens) {
        return (141.5d / dens) - 131.5d;
    }

    private double toDens(double api) {
        return 141.5d / (131.5d + api);
    }
}
