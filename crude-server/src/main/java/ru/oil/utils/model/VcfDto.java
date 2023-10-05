package ru.oil.utils.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor(staticName = "create")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class VcfDto {

    double vcf;
}
