package br.com.tds.teste.model;

import java.util.List;

import javax.persistence.EntityManager;

public class ProfessorService extends Professor {

	private ProfessorDAO professorDAO;

	public ProfessorService(EntityManager em) {
		this.professorDAO = new ProfessorDAO(em);
	}

	public void incluir(Professor professor) {
		professorDAO.inserir(professor);
	}

	public List<Professor> listarTodos(){
		return professorDAO.SelectAll();
	}
	public void excluir(Professor professor){
		professorDAO.excluir(professor.getId());
	}
	
}
