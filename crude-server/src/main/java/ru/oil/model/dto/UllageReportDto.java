package ru.oil.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor(staticName = "create")
@RequiredArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UllageReportDto {
    String tank;
    Double ullage;
    Double govBbls;
    Double gsvBbls;
    Double mt;
    Double lt;
    Double api;
    Double temperature;
    Double vcf;

}
