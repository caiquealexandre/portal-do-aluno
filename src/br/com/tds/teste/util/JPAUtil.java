package br.com.tds.teste.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory factory;
	
	static{
		factory = Persistence.createEntityManagerFactory("pessoas-postgres");
	}
	
	public EntityManager getEntityManager(){
		EntityManager em = factory.createEntityManager();
		return em;
	}
}
