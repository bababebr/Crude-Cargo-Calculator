package com.example.oct.ullageReport;

import com.example.oct.enums.Tables;
import com.example.oct.tank.Tank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Map;
import java.util.TreeMap;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor(staticName = "create")
public class UllageReport {

    Map<String, Tank> tanks = new TreeMap<>();
    final Tables table;

    public void addTank(String name, Tank tank) {
        tanks.put(name, tank);
    }

    public double getBblsGsv(String name) {
        Tank tank = tanks.get(name);
        return tank.getCargo().getVcf().getVcf() * tank.getBblsTov();
    }

}
