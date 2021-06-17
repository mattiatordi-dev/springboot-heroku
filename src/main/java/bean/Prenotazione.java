package bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

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
	
	/*@ManyToOne
	@MapsId("utenteId")
	@JoinColumn(name = "utente_id")
    Utente utente;
	
	@ManyToOne
	@MapsId("mezzoId")
	@JoinColumn(name = "mezzo_id")
    Mezzo mezzo;
    */
	
	@Column
	private int data_prenotazione;
	
	public Prenotazione() {
		super();
	}

	public Prenotazione(int id, Utente utente, Mezzo mezzo, int data_prenotazione) {
		super();
		this.id = id;
		this.utente = utente;
		this.mezzo = mezzo;
		this.data_prenotazione = data_prenotazione;
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

	public int getData_prenotazione() {
		return data_prenotazione;
	}

	public void setData_prenotazione(int data_prenotazione) {
		this.data_prenotazione = data_prenotazione;
	}

	@Override
	public String toString() {
		return "Prenotazione [id=" + id + ", utente=" + utente + ", mezzo=" + mezzo + ", data_prenotazione="
				+ data_prenotazione + "]";
	}
	
	
	
}
