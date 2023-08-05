package com.example.oct.ullageReport;

import com.example.oct.cargo.dto.CargoDto;
import com.example.oct.ullage.dto.UllageDtoFull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UllageReport {

    String tankName;
    UllageDtoFull ullage;
    CargoDto cargo;
    String table;

}
