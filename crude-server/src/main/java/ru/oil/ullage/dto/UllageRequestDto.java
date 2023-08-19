package ru.oil.ullage.dto;

import ru.oil.enums.Tables;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.*;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor(staticName = "create")
@AllArgsConstructor(staticName = "create")
public class UllageRequestDto {
    @NotNull
    String tankName;
    @NotNull
    @Positive
    double ullage;
    @Min(-1)
    @Max(4)
    double trim = 0;
    Tables table;
}
