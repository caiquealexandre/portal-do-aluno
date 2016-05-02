package br.com.tds.teste.model;

import java.util.List;

import javax.persistence.EntityManager;

public class TurmaDAO {

	private EntityManager em;

	public TurmaDAO(EntityManager em) {
		this.em = em;
	}

	public void inserir(Turma turma) {
		em.persist(turma);
	}

	public void excluir(Turma turma) {
		em.remove(turma);
	}

	public void excluir(Long id) {
		Turma t = selectById(id);
		em.remove(t);
	}

	public void atualizar(Turma turma) {
		em.merge(turma);
	}

	public Turma selectById(Long id) {
		return (Turma) em.find(Turma.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Turma> selectAll() {
		return (List<Turma>) em.createQuery("select t from Turma t ")
				.getResultList();
	}

}
