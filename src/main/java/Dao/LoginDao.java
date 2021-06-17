package Dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Util.JpaUtil;
import bean.Utente;

public class LoginDao {
	
	public Utente findBySurname(String surname) {
		EntityManager entity = JpaUtil.getEntityManager();
		entity.getTransaction().begin();
		Query query =  entity.createNativeQuery("SELECT u.id, u.cognome, u.data_nascita, u.nome, u.ruolo_admin,"
				+ "u.password FROM utente u WHERE u.cognome =:surname",Utente.class);
		query.setParameter("surname", surname);
		Utente u = (Utente) query.getSingleResult();
		
		return u;
	}
	
	

}
