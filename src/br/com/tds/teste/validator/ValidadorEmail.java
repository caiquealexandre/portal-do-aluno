package br.com.tds.teste.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "validatorEmail")
public class ValidadorEmail implements Validator {

	private Pattern pattern;
	private Matcher matcher;

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {

		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher((String) value);
		if (!matcher.matches()) {
			FacesMessage errorMsg = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Email Invalido", null);
			throw new ValidatorException(errorMsg);
		}

	}

}
