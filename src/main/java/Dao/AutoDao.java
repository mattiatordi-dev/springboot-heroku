package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Util.JpaUtil;
import bean.Mezzo;
import bean.Utente;

public class AutoDao {
	

	@SuppressWarnings("unchecked")
	public List<Mezzo> getAllAuto() {
		EntityManager entity = JpaUtil.getEntityManager();
		Query query = (Query) entity.createQuery("SELECT m FROM Mezzo m",Mezzo.class);
		List<Mezzo> lista = query.getResultList();
		return lista;
	}
	
	
	public void insertAuto(Mezzo m) {
		EntityManager entity = JpaUtil.getEntityManager();
		entity.getTransaction().begin();
		entity.persist(entity.merge(m));
		entity.getTransaction().commit();
		entity.close();
	}
	
	public Mezzo getAuto(int id) {
		EntityManager entity = JpaUtil.getEntityManager();
		entity.getTransaction().begin();
		Query query = entity.createQuery("SELECT m FROM Mezzo m WHERE id=:value");
		query.setParameter("value", id);
		Mezzo m = (Mezzo) query.getSingleResult();
		
		return m;
	}
	

}
