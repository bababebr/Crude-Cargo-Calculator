package ru.oil.ullageReport.model;

import ru.oil.cargo.dto.CargoDto;
import ru.oil.ullage.dto.UllageDtoFull;
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
