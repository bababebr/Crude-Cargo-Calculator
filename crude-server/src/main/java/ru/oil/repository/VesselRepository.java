package ru.oil.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.oil.model.Vessel;

public interface VesselRepository extends JpaRepository<Vessel, UUID> {



}
