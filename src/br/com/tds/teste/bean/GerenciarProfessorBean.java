package br.com.tds.teste.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;

import br.com.tds.teste.model.Professor;
import br.com.tds.teste.model.ProfessorService;
import br.com.tds.teste.util.JPAUtil;

@ManagedBean(name = "pr")
@RequestScoped
public class GerenciarProfessorBean implements Serializable {

	private Professor professor;

	@PostConstruct
	public void init() {
		professor = new Professor();
	}

	public String cadastrarProfessor() {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		ProfessorService service = new ProfessorService(em);

		service.incluir(professor);
		em.getTransaction().commit();
		professor = new Professor();
		return null;
	}

	public String getMensagem() {
		return "Teste JSF";
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor string) {
		this.professor = string;
	}

	public List<Professor> getProfessores() {
		EntityManager em = new JPAUtil().getEntityManager();
		ProfessorService service = new ProfessorService(em);
		return service.listarTodos();
	}

	public void excluirProfessor(Professor p) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		ProfessorService service = new ProfessorService(em);
		service.excluir(p);
		em.getTransaction().commit();
	}

	public void seleciona(Professor p) {
		this.professor = p;
	}

}
