package com.example.demo.repository;

import com.example.demo.model.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NamedNativeQuery;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Prenotazione, Integer> {


    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM prenotazione p WHERE p.data_prenotazione like :data% ",nativeQuery = true)
    List<Prenotazione> searchByDate(String data);

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM prenotazione p,utente u,mezzo m " +
            " WHERE p.utente_id = u.id and p.mezzo_id = m.id" +
            " and u.cognome = :cognome ",nativeQuery = true)
    List<Prenotazione> getPrenFromLastname(String cognome);


}
