package presentation.validators;

import java.util.List;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import model.User;
import model.exceptions.BusinessException;
import conf.ServicesFactory;
@FacesValidator("presentation.validators.NewUserValidator")
public class NewUserValidator implements Validator{
	
	@Override
	public void validate(FacesContext facesContext, UIComponent component,
			Object obj) throws ValidatorException {
		String newUserName = obj.toString();
		List<User> usr = null;
		
		try {
			usr = ServicesFactory.getUserService().findAllUsers();
			for(User u : usr){
				if(u.getUser().equals(newUserName)){
					showMessage(facesContext);
				}
			}
	
		} catch (BusinessException e) {
		}
		
	}
	
	private void showMessage(FacesContext facesContext){
		ResourceBundle bundle = facesContext.getApplication()
				.getResourceBundle(facesContext, "msgs");
		FacesMessage msg = new FacesMessage(			
				bundle.getString("usuarioYaExiste"));
		msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		throw new ValidatorException(msg);
	}

}
