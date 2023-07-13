package units;

import lombok.Data;

@Data
public class Api {

    private double api;
    private double dens;

    public static Api fromApi(double api) {
        Api a = new Api();
        a.setApi(api);
        a.setDens(a.toDens(api));
        return a;
    }

    public static Api formDens(double dens) {
        Api a = new Api();
        a.setDens(dens);
        a.setApi(a.toApi(dens));
        return a;
    }

    private double toApi(double dens) {
        return (141.5d / dens) - 131.5;
    }

    private double toDens(double api) {
        return 141.5d / (131.5 + api);
    }
}
