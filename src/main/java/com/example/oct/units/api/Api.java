package com.example.oct.units.api;

import com.sun.xml.bind.v2.TODO;
import lombok.Data;

@Data
public class Api {

    /**
     * TODO
     * Refactor Api/Dens
     *  - Api
     *  - Dens Vac
     *  - Dens Air
     *  - Dens Temp
     *  - Specific Gravity
     */
    private double api;
    private double specificGravity;
    private double densAir;
    private double densVac;

    public static Api fromApi(double api) {
        Api a = new Api();
        a.setApi(api);
        a.setSpecificGravity(a.toSpecGravity(api));
        a.setDensAir(a.densVac - 0.0011);
        return a;
    }

    public static Api formDens(double densVac) {
        Api a = new Api();
        a.setDensVac(densVac);
        a.setApi(a.toApi(densVac));
        a.setSpecificGravity(a.toSpecGravity(a.api));
        a.setDensAir(a.densVac - 0.0011);
        return a;
    }

    private double toApi(double dens) {
        return (141.5d / dens) - 131.5d;
    }

    private double toSpecGravity(double api) {
        return 141.5d / (131.5d + api);
    }

    public double fromApiToDensVac(double api) {

    }
}
