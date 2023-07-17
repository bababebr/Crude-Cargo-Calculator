package com.example.oct.cargo;

import com.example.oct.units.Api;
import com.example.oct.units.Temperature;
import com.example.oct.units.vcf.Vcf;
import com.example.oct.units.vcf.Vcf54A;
import com.example.oct.units.vcf.Vcf6A;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Cargo {

    String name;
    Api api;
    Temperature temperature;
    CargoType type;
    @NonFinal
    Vcf vcf;

    public static Cargo create(String name, Api api, Temperature temperature, CargoType type, boolean gsvTemp) {
        Cargo cargo = new Cargo(name, api, temperature, type);
        switch (type){
            case CRUDE:
                if(gsvTemp){
                    cargo.setVcf(Vcf6A.create(api, temperature));
                }
            case FUEL:
                if(gsvTemp) {
                    cargo.setVcf(Vcf54A.create(api, temperature));
                }
        }
        return cargo;
    }
}
