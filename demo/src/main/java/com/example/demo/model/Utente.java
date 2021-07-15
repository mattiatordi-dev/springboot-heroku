package com.example.demo.model;

import com.example.demo.security.models.UserRoleModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="utente")
public class Utente implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    @NotNull
    @Size(min = 2, max = 12)
    private String nome;
    @Column
    @NotNull
    @Size(min = 2, max = 12)
    private String cognome;
    @Column(name="data_nascita")
    @NotNull
    private LocalDate dataNascita;
    @Column
    private boolean ruoloAdmin;
    @OneToMany(mappedBy="utente", cascade = CascadeType.ALL)
    Set<Prenotazione> lista;
    @Column
    @NotNull
    @Size(min = 2, max = 8)
    private String password;

    @Transient
    private String hashedUserPass;

    @Transient
    private List<UserRoleModel> userRoles;
    public Utente()
    {
        userRoles = new ArrayList<UserRoleModel>();
    }

    public Utente(int id,String nome, String cognome, LocalDate dataNascita) {
        super();
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
    }

    public Utente(int id, String nome, String cognome, LocalDate dataNascita, boolean ruoloAdmin) {
        super();
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.ruoloAdmin = ruoloAdmin;
    }


    public Utente(int id, String nome, String cognome, LocalDate dataNascita, String password) {
        super();
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.password = password;
    }

    public Utente(int id, String nome, String cognome, LocalDate dataNascita, boolean ruoloAdmin, String password) {
        super();
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.ruoloAdmin = ruoloAdmin;
        this.password = password;
    }

    public Utente(int id, String nome, String cognome, LocalDate dataNascita, boolean ruoloAdmin,
                  Set<Prenotazione> lista) {
        super();
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.ruoloAdmin = ruoloAdmin;
        this.lista = lista;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public LocalDate getData_nascita() {
        return dataNascita;
    }

    public void setData_nascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public boolean isRuolo_admin() {
        return ruoloAdmin;
    }

    public Set<Prenotazione> getLista() {
        return lista;
    }

    public void setLista(Set<Prenotazione> lista) {
        this.lista = lista;
    }

    public void setRuolo_admin(boolean ruoloAdmin) {
        this.ruoloAdmin = ruoloAdmin;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return cognome;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", data_nascita=" + dataNascita
                + ", ruolo_admin=" + ruoloAdmin + ", password=" + password  + "]";
    }

    public String getHashedUserPass()
    {
        return hashedUserPass;
    }

    public void setHashedUserPass(String hashedUserPass)
    {
        this.hashedUserPass = hashedUserPass;
    }

    public List<UserRoleModel> getUserRoles()
    {
        return userRoles;
    }

    public void setUserRoles(List<UserRoleModel> userRoles)
    {
        this.userRoles = userRoles;
    }
}



