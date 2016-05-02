package br.com.tds.teste.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.tds.teste.model.Pessoa;
import br.com.tds.teste.model.PessoaService;
import br.com.tds.teste.model.Turma;
import br.com.tds.teste.model.TurmaService;
import br.com.tds.teste.util.JPAUtil;

@ManagedBean(name = "gp")
@ViewScoped
public class GerenciarPessoaBean implements Serializable {

	private Pessoa pessoa;

	private List<Turma> turmas;

	// private Long turmaId;

	@PostConstruct
	public void init() {
		pessoa = new Pessoa();
		turmas = obterTurmas();
	}

	private List<Turma> obterTurmas() {
		EntityManager em = new JPAUtil().getEntityManager();
		TurmaService service = new TurmaService(em);
		List<Turma> turmas = service.listarTodas();
		em.close();
		return turmas;
	}

	public String cadastrarPessoa() {

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		PessoaService service = new PessoaService(em);

		// TurmaService turmaService = new TurmaService(em);
		// Turma turma = turmaService.selectById(turmaId);
		// pessoa.setTurma(turma);

		service.incluir(pessoa);
		em.getTransaction().commit();
		pessoa = new Pessoa();

		return null;
	}

	public String getMensagem() {
		return "Teste JSF";
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa string) {
		this.pessoa = string;
	}

	public List<Pessoa> getPessoas() {
		EntityManager em = new JPAUtil().getEntityManager();
		PessoaService service = new PessoaService(em);
		return service.listarTodos();
	}

	public void excluirPessoa(Pessoa p) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		PessoaService service = new PessoaService(em);
		service.excluir(p);
		em.getTransaction().commit();
	}

	public void seleciona(Pessoa p) {
		this.pessoa = p;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	// public Long getTurmaId() {
	// return turmaId;
	// }
	//
	// public void setTurmaId(Long turmaId) {
	// this.turmaId = turmaId;
	// }
	//

}
