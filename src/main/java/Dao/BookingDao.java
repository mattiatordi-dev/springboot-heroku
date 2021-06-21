package Dao;

import javax.persistence.EntityManager;

import Util.JpaUtil;
import bean.Prenotazione;

public class BookingDao {
	
	public void insertBooking(Prenotazione p) {
		EntityManager entity = JpaUtil.getEntityManager();
		entity.getTransaction().begin();
		entity.persist(entity.merge(p));
		entity.getTransaction().commit();
		entity.close();
	}

}
