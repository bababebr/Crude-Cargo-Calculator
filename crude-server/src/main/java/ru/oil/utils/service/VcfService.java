package ru.oil.utils.service;

import org.springframework.stereotype.Service;
import ru.oil.enums.Tables;
import ru.oil.exception.UtilsException;
import ru.oil.units.api.Api;
import ru.oil.units.temperature.Temperature;
import ru.oil.units.vcf.*;
import ru.oil.utils.mapper.VcfMapper;
import ru.oil.utils.model.VcfDto;

@Service
public class VcfService implements IVcfService {
    @Override
    public VcfDto getVcf(double apiOrDensity, double temperature, Tables table, boolean isApi, boolean isCelsius) {
        Api api = isApi ? Api.fromApi(apiOrDensity) : Api.formDens(apiOrDensity);
        Temperature temp = isCelsius ? Temperature.fromCelsius(temperature) : Temperature.fromFahrenheit(temperature);
        switch (table) {
            case Table6A:
                return VcfMapper.vcfToDto(Vcf6A.create(api, temp));
            case Table6B:
                return VcfMapper.vcfToDto(Vcf6B.create(api, temp));
            case Table54A:
                return VcfMapper.vcfToDto(Vcf54A.create(api, temp));
            case Table54B:
                return VcfMapper.vcfToDto(Vcf54B.create(api, temp));
            case Table6:
                throw new UtilsException("Table 6 not implemented yet.");
            default:
                throw new UtilsException(String.format("Table=%s not exist", table));
        }
    }
}
