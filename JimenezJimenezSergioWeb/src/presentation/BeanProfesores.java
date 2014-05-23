package presentation;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import conf.ServicesFactory;
import model.Profesor;
import model.exceptions.BusinessException;

@ManagedBean(name = "profesor_controller")
@SessionScoped
public class BeanProfesores implements Serializable {
	private static final long serialVersionUID = 55555L;

	private Profesor profesor = new Profesor();

	private Profesor[] profesores = null;

	public BeanProfesores() {
		iniciaProfesor(null);
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Profesor[] getProfesores() {
		return profesores;
	}
	
	public void setProfesoresToNull(ActionEvent event){
		this.profesor=null;
		this.profesores=null;
	}

	public void setProfesores(Profesor[] profesores) {
	
		this.profesores = profesores;
	}

	public void iniciaProfesor(ActionEvent event) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		// Obtenemos el archivo de propiedades correspondiente al idioma que
		// tengamos seleccionado y que viene envuelto en facesContext/*
		ResourceBundle bundle = facesContext.getApplication()
				.getResourceBundle(facesContext, "msgs");
		this.profesor=new Profesor();
		profesor.setUser(bundle.getString("valorDefectoUserId"));
		profesor.setName(bundle.getString("valorDefectoNombre"));
		profesor.setSurname(bundle.getString("valorDefectoApellidos"));
		profesor.setMail(bundle.getString("valorDefectoCorreo"));
	}

	public String listadoPublico(){
		try {
			profesores = ServicesFactory.getProfesoresService().findAllProfesores().toArray(new Profesor[0]);
			return "listadoProfesores";
		} catch (BusinessException e) {
			
			return "error";
		}
	}

	public String addProfesor() {
		try {
			ServicesFactory.getProfesoresService().addProfesor(this.profesor);
		} catch (BusinessException e) {
			
			return "error";
		}
		return "exito";
	}
	
	public String listadoProfesoresByAsignaturaId(Long id){
		try {
			profesores = ServicesFactory.getProfesoresService().findProfesoresByAsignaturaId(id).toArray(new Profesor[0]);
			if(profesores.length==0){profesores=null;}
			return "listadoAsignaturas";
		} catch (BusinessException e) {
			return "error";
		}
		
	}
	
	/*	public String listadoAsignaturasByProfesorId(String id){
		try {
			asignaturas=ServicesFactory.getAsignaturasService().findAsignaturasByProfesorId(id).toArray(new Asignatura[0]);
			if(asignaturas.length==0){asignaturas=null;}
			return "listadoProfesores";
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			return "error";
		}
	}*/

}
