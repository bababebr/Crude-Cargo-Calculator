package ru.oil.model;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import ru.oil.enums.VesselType;

@Entity
@Getter
@Setter
public class Vessel {

  @Id
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
  private UUID id;
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
