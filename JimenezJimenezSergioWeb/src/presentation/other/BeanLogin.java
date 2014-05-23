package presentation.other;

import java.io.Serializable;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Alumno;
import model.Profesor;
import model.User;
import model.exceptions.BusinessException;
import model.types.Roles;
import business.UserService;
import conf.ServicesFactory;

@ManagedBean(name = "login")
@SessionScoped
public class BeanLogin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name = "";
	private String password = "";
	private String result = "login_form_result_valid";

	public BeanLogin() {

		System.out.println("BeanLogin - no existe");
	}

	public String verify() {
		UserService userService = ServicesFactory.getUserService();
		User user = null;
		try {
			user = userService.verify(name, password);
		} catch (BusinessException e) {
			return "error";
		}

		if (user != null) {
			String result = "";
			if (user instanceof Alumno) {
				result = "/restricted/" + Roles.ALUMNO.toString().toLowerCase()
						+ "/index";
			} else if (user instanceof Profesor) {
				result = "/restricted/"
						+ Roles.PROFESOR.toString().toLowerCase() + "/index";
			} else {
				result = "/restricted/" + Roles.ADMIN.toString().toLowerCase()
						+ "/index";
			}
			putUserInSession(user);
			return result;

		} else {
			setResult("login_form_result_error");
			return "index";
		}
	}

	private void putUserInSession(User user) {
		Map<String, Object> session = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		if (session.get("LOGGEDIN_USER") == null) {
			session.put("LOGGEDIN_USER", user);
		} else {
			session.remove("LOGGEDIN_USER");
			session.put("LOGGEDIN_USER", user);
		}

	}

	public String getResult() {
		return result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
