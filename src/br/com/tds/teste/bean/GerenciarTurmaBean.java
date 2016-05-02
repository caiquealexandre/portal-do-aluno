package br.com.tds.teste.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.tds.teste.model.Turma;
import br.com.tds.teste.model.TurmaService;
import br.com.tds.teste.util.JPAUtil;

@ManagedBean(name = "tb")
@RequestScoped
public class GerenciarTurmaBean implements Serializable {

	private Turma turma;

	private List<Turma>listaTurmas;
	
	@PostConstruct
	public void init() {
		turma = new Turma();
	}

	public String cadastrarTurma() {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		TurmaService service = new TurmaService(em);
		service.incluir(turma);
		em.getTransaction().commit();
		turma = new Turma();
		return null;
	}

	public String getMensagem() {
		return "Teste JSF";
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma string) {
		this.turma = string;
	}

	public void seleciona(Turma t) {
		this.turma = t;
	}

	
	public Turma selectById(Long id) {
		EntityManager em = new JPAUtil().getEntityManager();
		return (Turma) em.find(Turma.class, id);
	}
	
	public List<Turma> getTurmas() {
		EntityManager em = new JPAUtil().getEntityManager();
		TurmaService service = new TurmaService(em);
		return service.listarTodas();
	}

	public void excluirTurma(Turma t) {

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		TurmaService service = new TurmaService(em);
		service.excluir(t);
		em.getTransaction().commit();
	}
	public void testeTurma()
	{
		System.out.println("TESTE COM SUCESSO!");
		
		System.out.println(turma.getAnoEtapa());
	}

	public List<Turma> getListaTurmas() {
		setListaTurmas(getTurmas());
		return this.listaTurmas;
	}

	public void setListaTurmas(List<Turma> listaTurmas) {
		this.listaTurmas = listaTurmas;
	}
	

}