package com.example.oct;

import com.example.oct.cargo.Cargo;
import com.example.oct.cargo.CargoType;
import com.example.oct.tables.Tables;
import com.example.oct.tank.Tank;
import com.example.oct.ullageReport.UllageReport;
import com.example.oct.units.Api;
import com.example.oct.units.Temperature;

public class test {

    public static void main(String[] args) {
        Cargo cargo = Cargo.create("Dubai CO", Api.formDens(0.95), Temperature.fromCelius(55), CargoType.CRUDE, true);
        Tank tank = Tank.fromCub(cargo,10000);

        UllageReport ullageReport = UllageReport.create(Tables.Table6A);
        ullageReport.addTank("1P", tank);
        System.out.println(ullageReport.getBblsGsv("1P"));
    }

}
