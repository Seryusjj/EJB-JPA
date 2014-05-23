package presentation.other;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "settings")
@SessionScoped
public class BeanSettings implements Serializable {
	private static final long serialVersionUID = 2L;
	private static final Locale ENGLISH = new Locale("en");
	private static final Locale SPANISH = new Locale("es");
	private Locale locale = new Locale("es");

	public Locale getLocale() {
		// Aqui habría que cambiar algo de código para coger
		// locale del navegador//la primera vez que se accede a getLocale()
		// aunque de momento lo dejamos así.
		return (locale);
	}

	public void setSpanish(ActionEvent event) {
		locale = SPANISH;
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}

	public void setEnglish(ActionEvent event) {
		locale = ENGLISH;
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}

	public String goHome() {
		return "index";
	}

}
