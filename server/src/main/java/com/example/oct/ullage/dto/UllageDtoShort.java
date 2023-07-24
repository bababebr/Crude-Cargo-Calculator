package com.example.oct.ullage.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor(staticName = "create")
public class UllageDtoShort {

    String name;
    Double ullage;
    Double tovCub;
    Double vcf;
    Double GsvBbls;
    Double gsvCub;
    Double metricTons;
    Double LongTons;

}
