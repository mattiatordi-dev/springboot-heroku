package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Util.JpaUtil;
import bean.Utente;

public class UserDao {
	
	@SuppressWarnings("unchecked")
	public List<Utente> getAllUsers(){
	EntityManager entity = JpaUtil.getEntityManager();
	entity.getTransaction().begin();
	Query query = entity.createQuery("SELECT u FROM Utente u");
	List<Utente> lista = query.getResultList();
	
	return lista;
	}
	
	public Utente getUser(int id) {
		EntityManager entity = JpaUtil.getEntityManager();
		entity.getTransaction().begin();
		Query query = entity.createQuery("SELECT u FROM Utente u WHERE id=:value");
		query.setParameter("value", id);
		Utente u = (Utente) query.getSingleResult();
		
		return u;
	}
	
}
