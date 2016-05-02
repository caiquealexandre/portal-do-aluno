package br.com.tds.teste.model;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Transaction;

public class PessoaDAO {

	private EntityManager em;

	public PessoaDAO(EntityManager em) {
		this.em = em;
	}

	public void inserir(Pessoa pessoa) {		
		em.persist(pessoa);
	}

	public void excluir(Pessoa pessoa) {
		em.remove(pessoa);
	}

	public void excluir(Long id) {
		Pessoa p = selectById(id);
		em.remove(p);
	}

	public void atualizar(Pessoa pessoa) {
		em.merge(pessoa);
	}

	public Pessoa selectById(Long id) {
		return (Pessoa) em.find(Pessoa.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> selectAll() {
		return (List<Pessoa>) em.createQuery("select p from Pessoa p ")
				.getResultList();
	}
}
