package com.ship4all.service.crude.repository;

import com.ship4all.service.crude.model.Vessel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VesselRepository extends JpaRepository<Vessel, UUID> {

}
