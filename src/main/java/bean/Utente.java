package bean;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="utente")
public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String nome;
	@Column
	private String cognome;
	@Column(name="data_nascita")
	private String dataNascita;
	@Column
	private boolean ruolo_admin;
    @OneToMany(mappedBy="utente", cascade = CascadeType.ALL)
    Set<Prenotazione> lista;
    @Column
    private String password;
	
	public Utente() {
		super();
	}
	
	public Utente(int id,String nome, String cognome, String data_nascita) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = data_nascita;
	}

	public Utente(int id, String nome, String cognome, String data_nascita, boolean ruolo_admin) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = data_nascita;
		this.ruolo_admin = ruolo_admin;
	}
	

	public Utente(int id, String nome, String cognome, String data_nascita, String password) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = data_nascita;
		this.password = password;
	}

	public Utente(int id, String nome, String cognome, String data_nascita, boolean ruolo_admin, String password) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = data_nascita;
		this.ruolo_admin = ruolo_admin;
		this.password = password;
	}

	public Utente(int id, String nome, String cognome, String data_nascita, boolean ruolo_admin,
			Set<Prenotazione> lista) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = data_nascita;
		this.ruolo_admin = ruolo_admin;
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

	public String getData_nascita() {
		return dataNascita;
	}

	public void setData_nascita(String data_nascita) {
		this.dataNascita = data_nascita;
	}

	public boolean isRuolo_admin() {
		return ruolo_admin;
	}

	public Set<Prenotazione> getLista() {
		return lista;
	}

	public void setLista(Set<Prenotazione> lista) {
		this.lista = lista;
	}

	public void setRuolo_admin(boolean ruolo_admin) {
		this.ruolo_admin = ruolo_admin;
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", data_nascita=" + dataNascita
				+ ", ruolo_admin=" + ruolo_admin + ", password=" + password  + "]";
	}
	
	
	

}
