package br.com.tds.teste.model;

import java.util.List;

import javax.persistence.EntityManager;

public class TurmaService extends Turma {

	private TurmaDAO turmaDAO;

	public TurmaService(EntityManager em) {
		this.turmaDAO = new TurmaDAO(em);
	}
	
	public void incluir (Turma turma){
		turmaDAO.inserir(turma);
	}

	public List<Turma> listarTodas(){
		return turmaDAO.selectAll();
	}
	
	public void excluir(Turma turma){
		turmaDAO.excluir(turma.getId());
	}

	public Turma selectById(Long turmaId) {
		return turmaDAO.selectById(turmaId);
	}
}
