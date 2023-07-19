package com.example.oct.ullage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UllageRepository extends JpaRepository<Ullage, Long> {

    @Query("SELECT ull FROM Ullage as ull WHERE ull.id =?1")
    Ullage get(Long id);
}
