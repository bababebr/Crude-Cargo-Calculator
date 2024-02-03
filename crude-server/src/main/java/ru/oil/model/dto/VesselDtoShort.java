package ru.oil.model.dto;

import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.oil.enums.VesselType;

@Getter
@Setter
@RequiredArgsConstructor
public class VesselDtoShort {

  /** UUID судна */
  private UUID id;
  /** Название судна*/
  private String name;
  /** Флаг приписки */
  private String flag;
  /** Тип судна */
  private VesselType type;
}