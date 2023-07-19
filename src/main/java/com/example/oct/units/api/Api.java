package com.example.oct.units.api;

import lombok.Data;

@Data
public class Api {

    private double api;
    private double specificGravity;
    private double densAir;
    private double densVac;

    public static Api fromApi(double api) {
        Api a = new Api();
        a.setApi(api);
        a.setSpecificGravity(a.toSpecGravity(api));
        a.setDensAir(a.getSpecificGravity() - 0.0011);
        return a;
    }

    public static Api formDens(double densVac) {
        Api a = new Api();
        a.setSpecificGravity(densVac);
        a.setApi(a.toApi(densVac));
        a.setDensAir(a.getSpecificGravity() - 0.0011);
        return a;
    }

    private double toApi(double dens) {
        return (141.5d / dens) - 131.5d;
    }

    private double toSpecGravity(double api) {
        return 141.5d / (131.5d + api);
    }
}
