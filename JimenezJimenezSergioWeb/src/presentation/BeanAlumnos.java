package presentation;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import model.Alumno;

import model.User;
import model.exceptions.BusinessException;
import conf.ServicesFactory;

@ManagedBean(name = "alumno_controller")
@SessionScoped
public class BeanAlumnos implements Serializable {
	private static final long serialVersionUID = 55555L;

	private Alumno alumno = new Alumno();

	private Alumno[] alumnos = null;
	
	private Long idAlumno;
	private Long idAsignatura;

	public Long getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Long idAlumno) {
		this.idAlumno = idAlumno;
	}

	public Long getIdAsignatura() {
		return idAsignatura;
	}

	public void setIdAsignatura(Long idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	public BeanAlumnos() {
		iniciaAlumno(null);
	}

	public Alumno[] getAlumnos() {
		return (alumnos);
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumnos(Alumno[] alumnos) {
		this.alumnos = alumnos;
	}

	public void iniciaAlumno(ActionEvent event) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		// Obtenemos el archivo de propiedades correspondiente al idioma que
		// tengamos seleccionado y que viene envuelto en facesContext/*
		ResourceBundle bundle = facesContext.getApplication()
				.getResourceBundle(facesContext, "msgs");
		this.alumno = new Alumno();
		alumno.setUser(bundle.getString("valorDefectoUserId"));
		alumno.setName(bundle.getString("valorDefectoNombre"));
		alumno.setSurname(bundle.getString("valorDefectoApellidos"));
		alumno.setMail(bundle.getString("valorDefectoCorreo"));
	}
	
	public void iniciaAlumnos(ActionEvent event) {
		listadoAlumnos();
	}

	public String addAlumno() {
		try {

			ServicesFactory.getAlumnosService().addAlumno(this.alumno);
			return "exito";
		} catch (BusinessException e) {
			return "error";
		}
	}

	private void iniciaAlumnoUser(User user) {
		alumno.setId(user.getId());
		alumno.setName(user.getName());
		alumno.setMail(user.getMail());
		alumno.setSurname(user.getSurname());
		alumno.setPass("");
		alumno.setUser(user.getUser());
		alumno.setActive(true);
	}
	
	
	public String listadoAlumnos(){
		try {
			this.alumno=null;
			this.alumnos = ServicesFactory.getAlumnosService().findAllAlumnos().toArray(new Alumno[0]);
			return "/restricted/admin/matricularAlumno";
		} catch (BusinessException e) {
			return "error";
		}
		
	}

	public String iniciaUpdateAlumnoByItself(User user) {
		alumno = new Alumno();
		iniciaAlumnoUser(user);
		return "/restricted/alumno/editForm";
	}

	public String updateAlumno() {
		try {
			ServicesFactory.getAlumnosService().updateAlumno(alumno);
			return "success";
		} catch (BusinessException e) {
			return "error";
		}

	}
	

	
	public String AddAsignaturaToAlumno() {
		try {
			
			ServicesFactory.getMatriculadosService().addMatricula(alumno.getId(),idAsignatura);
			return "/restricted/admin/index";
		} catch (BusinessException e) {
			return "error";
		}

	}
	



	

	
}
