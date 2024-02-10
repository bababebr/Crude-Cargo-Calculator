package com.ship4all.service.crude.cargo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ship4all.service.crude.enums.CargoType;

import java.util.List;
import java.util.Optional;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
    Optional<Cargo> findByName(String name);

    List<Cargo> findAllByType(CargoType type);
}
