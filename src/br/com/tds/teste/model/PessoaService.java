package br.com.tds.teste.model;

import java.util.List;

import javax.persistence.EntityManager;

public class PessoaService extends Pessoa {

	private PessoaDAO pessoaDAO;

	public PessoaService(EntityManager em) {
		this.pessoaDAO = new PessoaDAO(em);
	}

	public void incluir(Pessoa pessoa) {
		if (pessoa.getId()==null){
			pessoaDAO.inserir(pessoa);
		}else{			
			pessoaDAO.atualizar(pessoa);
		}
	}

	public List<Pessoa> listarTodos() {
		// TODO - regra negocial
		return pessoaDAO.selectAll();
	}

	public void excluir(Pessoa pessoa) {
		pessoaDAO.excluir(pessoa.getId());

	}

}
