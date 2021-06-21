package Dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import Util.JpaUtil;
import bean.Prenotazione;
import bean.Utente;

public class InsertUserDao {

	
	public void insertUser(Utente u) {
		EntityManager entity = JpaUtil.getEntityManager();
		entity.getTransaction().begin();
		entity.persist(entity.merge(u));
		entity.getTransaction().commit();
		entity.close();
	}

}
