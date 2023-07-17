package com.example.oct.tank;

import com.example.oct.cargo.Cargo;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Map;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor(staticName = "create")
public class Tank {

    final Cargo cargo;
    double ullage;

    double bblsTov = 0;
    double cubTov = 0;

    public static Tank fromUll(Cargo cargo, double ullage, Map<Double, Double> soundingTable) {
        Tank tank = Tank.create(cargo);
        tank.setUllage(ullage);
        tank.setCubTov(soundingTable.get(ullage));
        return tank;
    }

    public static Tank fromCub(Cargo cargo, double cubTov) {
        Tank tank = Tank.create(cargo);
        tank.setCubTov(cubTov);
        tank.setBblsTov(cubTov * 6.28981);
        return tank;
    }

    public static Tank fromBbls(Cargo cargo, double bblsTov) {
        Tank tank = Tank.create(cargo);
        tank.setBblsTov(bblsTov);
        tank.setCubTov(bblsTov / 6.28981);
        return tank;
    }


}
