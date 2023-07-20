package com.example.oct.ullage.ullageReport;

import com.example.oct.enums.Tables;
import com.example.oct.ullage.UllageService;
import com.example.oct.units.api.Api;
import com.example.oct.units.temperature.Temperature;
import com.example.oct.units.vcf.Vcf;
import com.example.oct.units.vcf.Vcf54A;
import com.example.oct.units.vcf.Vcf6A;
import com.example.oct.units.wcf.Wcf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UllageReportService {

    @Autowired
    private UllageService service;

    public UllageReport report(String name, double ullage, double apiOrDensity, double t, Tables table) {
        Api api;
        Temperature temperature;
        Vcf vcf;
        if (table.equals(Tables.Table6A)) {
            api = Api.fromApi(apiOrDensity);
            temperature = Temperature.fromFahrenheit(t);
            vcf = Vcf6A.create(api, temperature);
            Wcf wcf = Wcf.create(vcf);
        } else if (table.equals(Tables.Table54A)) {
            api = Api.formDens(apiOrDensity);
            temperature = Temperature.fromCelius(t);
            vcf = Vcf54A.create(api, temperature);
            Wcf wcf = Wcf.create(vcf);
        } else {

        }
        return null;
    }
}
