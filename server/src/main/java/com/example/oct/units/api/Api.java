package com.example.oct.units.api;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Api {

    private double api;
    private double specificGravity;
    private double densAir;
    private double densVac;

    public static Api fromApi(double api) {
        Api a = new Api();
        a.setApi(api);
        a.setSpecificGravity(a.toSpecGravity(api));
        a.setDensVac(a.fromApiToDensVac(api));
        a.setDensAir(a.densVac - 0.0011);
        return a;
    }

    public static Api formDens(double densVac) {
        Api a = new Api();
        a.setDensVac(densVac);
        a.setSpecificGravity(a.fromDensVacToSpecificGravity(densVac));
        a.setApi(a.toApi(a.specificGravity));
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
        double specGravity = toSpecGravity(api);
        if (api > 94.88) return specGravity;
        if (api > 76.54) return specGravity - 0.0001;
        if (api > 59.65) return specGravity - 0.0002;
        if (api > 46.86) return specGravity - 0.0003;
        if (api > 32.95) return specGravity - 0.0004;
        if (api > 16.74) return specGravity - 0.0005;
        if (api > 3.31) return specGravity - 0.0006;
        else return specGravity - 0.0007;
    }

    public double fromDensVacToSpecificGravity(double densVac) {
        if (densVac > 0.74 && densVac < 0.793) return densVac + 0.0003;
        if (densVac >= 0.793 && densVac < 0.86) return densVac + 0.0004;
        if (densVac >= 0.86 && densVac < 0.954) return densVac + 0.0005;
        if (densVac >= 0.954 && densVac < 1.049) return densVac + 0.0006;
        else return densVac + 0.0007;

    }

    public static void main(String[] args) {
        Api api1 = Api.fromApi(25);
        System.out.println(api1);
        Api api2 = Api.formDens(0.91);
        System.out.println(api2);
    }
}
