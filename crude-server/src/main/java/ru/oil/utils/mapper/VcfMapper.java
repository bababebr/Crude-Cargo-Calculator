package ru.oil.utils.mapper;

import ru.oil.units.vcf.Vcf;
import ru.oil.utils.model.VcfDto;

public class VcfMapper {

    public static VcfDto vcfToDto(Vcf vcf) {
        return VcfDto.create(vcf.getVcf());
    }

}
