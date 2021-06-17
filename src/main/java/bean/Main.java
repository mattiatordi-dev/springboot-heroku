package bean;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import Util.JpaUtil;

/*public class Main {
	
	public static void main(String[] args) {
		EntityManager entity = JpaUtil.getEntityManager();
		entity.getTransaction().begin();
		
		Utente utente = new Utente(0,"mattia","tordi","31/03/1995",true);
		Mezzo mezzo = new Mezzo(0, "targa", "berlina", "audi", 2019, "SUV");
		
	    Prenotazione prenotazione = new Prenotazione(0,utente,mezzo,2020);
	    Prenotazione prenotazione1 = new Prenotazione(1,utente,mezzo,2019);
	    Prenotazione prenotazione2 = new Prenotazione(2,utente,mezzo,2018);
	    
	    Set<Prenotazione> lista = new HashSet<>();
	    
	    Collections.addAll(lista, prenotazione,prenotazione1,prenotazione2);
	    
	    utente.setLista(lista);
	    mezzo.setLista(lista);
	    
	 
	    
	    for(Prenotazione item : lista) {
	    	entity.persist(item);
	    }
	    
	    entity.getTransaction().commit();
	    entity.close();
	    
		
	}

}
*/
