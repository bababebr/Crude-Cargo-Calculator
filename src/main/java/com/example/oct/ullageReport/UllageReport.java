package com.example.oct.ullageReport;

import com.example.oct.cargo.dto.CargoDto;
import com.example.oct.ullage.Ullage;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UllageReport {

    String tankName;
    Ullage ullage;
    CargoDto cargo;
    String table;

}
