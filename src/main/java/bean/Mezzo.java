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
@Table(name="mezzo")
public class Mezzo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique=true)
	private String targa;
	@Column
	private String modello;
	@Column(name="casa_costr")
	private String casaCostr;
	@Column(name="anno_imm")
	private int annoImm;
	@Column(nullable = false)
	private String tipologia;
	@OneToMany(mappedBy = "mezzo", cascade = CascadeType.ALL)
	Set<Prenotazione> lista;
	
	public Mezzo() {
		super();
	}
	
	public Mezzo(int id,String targa, String modello, String casa_costr, String tipologia, int anno_imm) {
		super();
		this.id = id;
		this.targa = targa;
		this.modello = modello;
		this.casaCostr = casa_costr;
		this.annoImm = anno_imm;
		this.tipologia = tipologia;
	}

	public Mezzo(int id, String targa, String modello, String casa_costr, int anno_imm, String tipologia) {
		super();
		this.id = id;
		this.targa = targa;
		this.modello = modello;
		this.casaCostr = casa_costr;
		this.annoImm = anno_imm;
		this.tipologia = tipologia;
	}

	public Mezzo(int id, String targa, String modello, String casa_costr, int anno_imm, String tipologia,
			Set<Prenotazione> lista) {
		super();
		this.id = id;
		this.targa = targa;
		this.modello = modello;
		this.casaCostr = casa_costr;
		this.annoImm = anno_imm;
		this.tipologia = tipologia;
		this.lista = lista;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getCasa_costr() {
		return casaCostr;
	}

	public void setCasa_costr(String casa_costr) {
		this.casaCostr = casa_costr;
	}

	public int getAnno_imm() {
		return annoImm;
	}

	public void setAnno_imm(int anno_imm) {
		this.annoImm = anno_imm;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public Set<Prenotazione> getLista() {
		return lista;
	}

	public void setLista(Set<Prenotazione> lista) {
		this.lista = lista;
	}

	@Override
	public String toString() {
		return "Mezzo [id=" + id + ", targa=" + targa + ", modello=" + modello + ", casa_costr=" + casaCostr
				+ ", anno_imm=" + annoImm + ", tipologia=" + tipologia  + "]";
	}
	
	
	

}
