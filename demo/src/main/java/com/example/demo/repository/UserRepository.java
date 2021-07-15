package com.example.demo.repository;

import com.example.demo.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Utente, Integer> {

    Utente findByCognome(String cognome);

    Optional<Utente> findUserByCognome(String cognome);

    @Transactional
    @Modifying
    @Query("update Utente u set u.password = ?1 where u.password = ?2")
    void setUserPassword(String newPassword, String oldPassword);

    @Transactional
    @Modifying
    @Query("update Utente u set u.nome = ?2, u.cognome = ?3, u.dataNascita = ?4, u.password = ?5 where u.cognome = ?1 ")
    void updateUser(String oldLastname, String nome, String cognome, LocalDate dataNascita, String password);

    @Transactional
    @Modifying
    @Query("update Utente u set u.ruoloAdmin = ?1 where u.cognome = ?2")
    void setUserAdminValue(boolean ruoloAdmin, String lastName);
}
