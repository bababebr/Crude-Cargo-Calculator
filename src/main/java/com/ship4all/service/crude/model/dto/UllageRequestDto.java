package com.ship4all.service.crude.model.dto;

import com.ship4all.service.crude.enums.Tables;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor(staticName = "create")
@AllArgsConstructor(staticName = "create")
public class UllageRequestDto {
    @NotNull
    String tankName;
    Double ullage;
    Double trim = 0d;
    Tables table;
}
