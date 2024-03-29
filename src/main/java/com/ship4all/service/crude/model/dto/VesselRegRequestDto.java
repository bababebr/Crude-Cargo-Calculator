package com.ship4all.service.crude.model.dto;

import com.ship4all.service.crude.enums.VesselType;

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
