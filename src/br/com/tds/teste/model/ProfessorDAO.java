package br.com.tds.teste.model;

import java.util.List;

import javax.persistence.EntityManager;

public class ProfessorDAO {

	private EntityManager em;

	public ProfessorDAO(EntityManager em) {
		this.em = em;
	}

	public void inserir(Professor professor) {
		em.persist(professor);
	}

	public void excluir(Professor professor) {
		em.remove(professor);
	}

	public void excluir(Long id) {
		Professor p = selectById(id);
		em.remove(p);
	}

	public void atualizar(Professor professor) {
		em.merge(professor);
	}

	private Professor selectById(Long id) {
		return (Professor) em.find(Professor.class, id);
	}

	public List<Professor> SelectAll() {
		return (List<Professor>) em.createQuery("select p from Professor p")
				.getResultList();
	}

}
