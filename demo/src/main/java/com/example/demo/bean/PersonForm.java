package com.example.demo.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonForm {

    @NotNull(message = "Il nome deve essere compreso tra i 2 e i tre caratteri")
    @Size(min=2, max=30)
    private String nome;

    @NotNull(message = "Il cognome deve essere compreso tra i 2 e i tre caratteri")
    @Size(min=2, max=30)
    private String cognome;

    @NotNull(message = "La data di nascita è obbligatoria")
    private String dataNascita;

    @NotNull(message = "La password deve essere compresa tra i 4 e 8 caratteri")
    @Size(min=4, max=8)
    private String password;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}