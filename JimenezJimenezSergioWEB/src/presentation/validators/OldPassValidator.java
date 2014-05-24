package presentation.validators;

import java.util.ResourceBundle;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;

import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;



//Mejor dejalo con un nombre sencillo
@FacesValidator("presentation.validators.OldPassValidator")
public class OldPassValidator implements Validator {

	@Override
	public void validate(FacesContext facesContext, UIComponent component,
			Object obj) throws ValidatorException {
		String insertedPass = obj.toString();
		String correctPass = (String) component.getAttributes().get("actualPass");
		
		
		
		if (!insertedPass.equals(correctPass)) {
			ResourceBundle bundle = facesContext.getApplication()
					.getResourceBundle(facesContext, "msgs");
			FacesMessage msg = new FacesMessage(			
					bundle.getString("incorrectPass"));
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}


	}
}
