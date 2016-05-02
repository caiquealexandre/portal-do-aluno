package br.com.tds.teste.atualizabanco;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pessoas-postgres");
		//EntityManager em = 
	}
}
