package presentation.validators;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

//Mejor dejalo con un nombre sencillo
@FacesValidator("presentation.validators.TwoPassValidator")
public class TwoPassValidator implements Validator {

	@Override
	public void validate(FacesContext facesContext, UIComponent component,
			Object obj) throws ValidatorException {

		String pass1 = obj.toString();
		
		String endComponentId = (String) component.getAttributes().get("equalsTo");
		UIInput input = (UIInput) component.findComponent(endComponentId);
		
		String equalsTo = (String) input.getValue();
		
		
		if (pass1 != null && equalsTo != null) {
			if (!pass1.equals("") || !equalsTo.equals("")) {
				
				if (!pass1.equals(equalsTo)) {
					ResourceBundle bundle = facesContext.getApplication()
							.getResourceBundle(facesContext, "msgs");
					FacesMessage msg = new FacesMessage(
							bundle.getString("twoPassNotEqual"));
					msg.setSeverity(FacesMessage.SEVERITY_ERROR);
					throw new ValidatorException(msg);
				}
			}
		}
		// if(oldPass.equals(anObject))

	}
}
