package ru.oil.model;

import ru.oil.cargo.dto.CargoDto;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.oil.model.dto.UllageDtoFull;

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
