package com.ship4all.service.crude.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.ship4all.service.crude.model.Ullage;

@Repository
public interface UllageRepository extends JpaRepository<Ullage, Long> {

    Ullage findByUllageAndName(double ullage, String name);

    Boolean existsByName(String string);

    @Query("SELECT ull FROM Ullage as ull WHERE ull.name = ?1 order by abs(ull.ullage - ?2) asc")
    List<Ullage> getNextUllage(String name, double ullage, Pageable pageable);

    @Query("SELECT max(ull.ullage) FROM Ullage as ull WHERE ull.name =?1")
    Double maxUllage(String name);

}
