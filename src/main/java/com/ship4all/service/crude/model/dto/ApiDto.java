package com.ship4all.service.crude.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import com.ship4all.service.crude.model.Api;

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
