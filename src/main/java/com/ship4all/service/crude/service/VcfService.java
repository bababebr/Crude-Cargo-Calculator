package com.ship4all.service.crude.service;

import org.springframework.stereotype.Service;
import com.ship4all.service.crude.enums.Tables;
import com.ship4all.service.crude.exception.UtilsException;
import com.ship4all.service.crude.model.Vcf54A;
import com.ship4all.service.crude.model.Vcf54B;
import com.ship4all.service.crude.model.Vcf6A;
import com.ship4all.service.crude.model.Vcf6B;
import com.ship4all.service.crude.service.interfaces.IVcfService;
import com.ship4all.service.crude.model.Api;
import com.ship4all.service.crude.model.Temperature;
import com.ship4all.service.crude.mapper.VcfMapper;
import com.ship4all.service.crude.model.dto.VcfDto;

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
