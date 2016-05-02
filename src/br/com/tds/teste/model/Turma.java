package br.com.tds.teste.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_Turma")
public class Turma implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7117482040260858496L;

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, length = 50, unique = true)
	private String anoEtapa;
	@OneToMany(mappedBy="turma")
	private List<Pessoa>pessoas;

	// GENERATED GETTERS AND SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnoEtapa() {
		return anoEtapa;
	}

	public void setAnoEtapa(String anoEtapa) {
		this.anoEtapa = anoEtapa;
	}
	
	
	
	
	@Override
	public boolean equals(Object o){
		if (o!=null && o instanceof Turma){
			Turma t = (Turma) o;
			return t.getId().equals(getId());
		}
		return false;
	}

	@Override
	public int hashCode(){
        Long hash =  1l ; 
        hash = hash *  17  + id ; 
        hash = hash *  31  + anoEtapa.hashCode ( ) ; 
        return hash.intValue() ;
	}
}
