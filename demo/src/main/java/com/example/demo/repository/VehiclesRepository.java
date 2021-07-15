package com.example.demo.repository;

import com.example.demo.model.Mezzo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface VehiclesRepository extends JpaRepository<Mezzo, Integer> {

    @Query
    Mezzo findByModello(String modello);

    @Transactional
    @Modifying
    @Query("update Mezzo m set m.targa = ?1 where m.targa = ?2")
    void setVehicleTarga(String newTarga, String oldTarga);

    @Query
    Mezzo findByTarga(String targa);

}
