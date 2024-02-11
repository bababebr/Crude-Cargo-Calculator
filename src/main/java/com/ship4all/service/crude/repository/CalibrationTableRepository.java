package com.ship4all.service.crude.repository;

import com.ship4all.service.crude.model.CalibrationTable;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CalibrationTableRepository extends JpaRepository<CalibrationTable, Integer> {

  @Modifying
  @Query(value = "INSERT INTO calibration_table (tank, ullage, cub1f, cub, cub1a, cub2a, cub3a, cub4a, vessel_id) "
      + "VALUES (:tank, :ullage, :cub1f, :cub, :cub1a, :cub2a, :cub3a, :cub4a, :vesselId)", nativeQuery = true)
  void add(@Param("tank") String tank, @Param("ullage") double ullage, @Param("cub1f") double cub1f, @Param("cub") double cub,
      @Param("cub1a") double cub1a, @Param("cub2a") double cub2a, @Param("cub3a") double cub3a, @Param("cub4a") double cub4a,
      @Param("vesselId") UUID vessel_id);

  @Query(value = "SELECT EXISTS(SELECT id from calibration_table where vessel_id = :vesselId)", nativeQuery = true)
  Boolean vesselHasCalibrationTable(@Param("vesselId") UUID vesselId);

}
