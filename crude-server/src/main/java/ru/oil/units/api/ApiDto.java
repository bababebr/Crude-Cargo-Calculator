package ru.oil.units.api;

import lombok.*;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor(staticName = "create")
@AllArgsConstructor(staticName = "create")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiDto {
    Double api;
    Double densVac;

    public Api toApi() {
        if(api == null && densVac == null) throw new IllegalArgumentException("You must enter either API or Density");
        if(api == null) {
            return Api.formDens(densVac);
        } else {
            return Api.fromApi(api);
        }
    }
}
