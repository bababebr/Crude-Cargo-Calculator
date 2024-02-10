package com.ship4all.service.crude.model;

import com.ship4all.service.crude.cargo.dto.CargoDto;
import lombok.*;
import lombok.experimental.FieldDefaults;
import com.ship4all.service.crude.model.dto.UllageDtoFull;

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
