package Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class JpaUtil {
	private static final String NOME_PERSISTENCE_UNIT = "corso_jpa";
	private static EntityManager entityManager;

	private JpaUtil() {}
	
	public static EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(NOME_PERSISTENCE_UNIT);
		entityManager = entityManagerFactory.createEntityManager();
		
		return entityManager;
	}

}



