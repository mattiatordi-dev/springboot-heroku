package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
	
	@SuppressWarnings("unchecked")
	public List<Prenotazione> getBookingUser(int id){
		EntityManager entity = JpaUtil.getEntityManager();
		Query query = entity.createNativeQuery("SELECT * FROM prenotazione p WHERE p.utente_id=:id",Prenotazione.class);
		query.setParameter("id", id);
		List<Prenotazione> lista = query.getResultList();
		
		return lista;
	}
	
	public Prenotazione getFirstBooking(int id) {
		EntityManager entity = JpaUtil.getEntityManager();
		Query query = entity.createNativeQuery("SELECT * FROM prenotazione p WHERE p.id=:id",Prenotazione.class);
		query.setParameter("id", id);
		Prenotazione prenotazione = (Prenotazione) query.getSingleResult();
		
		return prenotazione;
	}
	
	
	public void deleteBooking(int id) {
		EntityManager entity = JpaUtil.getEntityManager();
		entity.getTransaction().begin();
		Query query = entity.createQuery("DELETE Prenotazione WHERE id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
		entity.getTransaction().commit();
		entity.close();
	}

}
