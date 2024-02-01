package ru.oil.mapper;

import ru.oil.model.Vcf;
import ru.oil.model.dto.VcfDto;

public class VcfMapper {

    public static VcfDto vcfToDto(Vcf vcf) {
        return VcfDto.create(vcf.getVcf());
    }

}
