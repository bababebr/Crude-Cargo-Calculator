package com.ship4all.service.crude.mapper;

import com.ship4all.service.crude.model.dto.VcfDto;
import com.ship4all.service.crude.model.Vcf;

public class VcfMapper {

    public static VcfDto vcfToDto(Vcf vcf) {
        return VcfDto.create(vcf.getVcf());
    }

}
