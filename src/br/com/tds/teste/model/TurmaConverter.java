package br.com.tds.teste.model;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.tds.teste.bean.GerenciarTurmaBean;

@FacesConverter(forClass=Turma.class)
public class TurmaConverter implements Converter {

	private static Map<String,Turma> turmas = new HashMap<String, Turma>();
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		System.out.println("Converter ..........getAsObject");
		
		
		GerenciarTurmaBean turma = new GerenciarTurmaBean();
		return  turma.selectById(  Long.valueOf(value) );
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		/*
		Turma t = (Turma) value;
		turmas.put(Long.toString(t.getId()), t);
		return Long.toString(t.getId());
		*/
		System.out.println("Converter ..........getAsString");
		 if (value instanceof Turma) {  
			 Turma turma = (Turma) value;  
	            return turma.getId().toString();  
	        }  
		 
		 return "";
	}

}
