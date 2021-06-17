package bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@SuppressWarnings("serial")
@Embeddable
public class PrenotazioneKey implements Serializable {

	@Column(name = "utente_id")
	private int utenteId;
	@Column(name = "mezzo_id")
	private int mezzoId;

	public PrenotazioneKey() {
		super();
	}

	public PrenotazioneKey(int utente_id, int mezzo_id) {
		super();
		this.utenteId = utente_id;
		this.mezzoId = mezzo_id;
	}

	public int getUtente_id() {
		return utenteId;
	}

	public void setUtente_id(int utente_id) {
		this.utenteId = utente_id;
	}

	public int getMezzo_id() {
		return mezzoId;
	}
	

	public void setMezzo_id(int mezzo_id) {
		this.mezzoId = mezzo_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mezzoId;
		result = prime * result + utenteId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrenotazioneKey other = (PrenotazioneKey) obj;
		if (mezzoId != other.mezzoId)
			return false;
		if (utenteId != other.utenteId)
			return false;
		return true;
	}
	
	

}
