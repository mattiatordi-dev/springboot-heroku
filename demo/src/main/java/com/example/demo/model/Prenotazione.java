package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="prenotazione")
public class Prenotazione {

    @Id
    int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "utente_id")
    Utente utente;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mezzo_id")
    Mezzo mezzo;

    @Column(name="data_prenotazione")
    private LocalDate dataPrenotazione;

    public Prenotazione() {
        super();
    }

    public Prenotazione(int id, Utente utente, Mezzo mezzo, LocalDate dataPrenotazione) {
        super();
        this.id = id;
        this.utente = utente;
        this.mezzo = mezzo;
        this.dataPrenotazione = dataPrenotazione;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }

    public LocalDate getData_prenotazione() {
        return dataPrenotazione;
    }

    public void setData_prenotazione(LocalDate dataPrenotazione) {
        this.dataPrenotazione = dataPrenotazione;
    }

    @Override
    public String toString() {
        return "Prenotazione [id=" + id + ", utente=" + utente + ", mezzo=" + mezzo + ", data_prenotazione="
                + dataPrenotazione + "]";
    }



}

