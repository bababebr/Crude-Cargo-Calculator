package ru.oil.model.dto;

import ru.oil.enums.VesselType;

public class VesselRegRequestDto {

  /** Название судна*/
  private String name;
  private String callSign;
  /** Флаг приписки */
  private String flag;
  /** Тип судна */
  private VesselType type;
  /** Длина судна в см */
  private Integer length;
  /** Ширина судна в см */
  private Integer width;

}
