package presentation;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import conf.ServicesFactory;
import model.Asignatura;
import model.exceptions.BusinessException;

@ManagedBean(name = "asignatura_controller")
@SessionScoped
public class BeanAsignaturas implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Asignatura[] asignaturas;
	private Asignatura asignatura;
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Asignatura[] getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(Asignatura[] asignaturas) {
		this.asignaturas = asignaturas;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public void setAsignaturasToNull(ActionEvent event) {
		this.asignatura = null;
		this.asignaturas = null;
	}

	public String listadoAsignaturasByProfesorId(Long id) {
		try {
			asignaturas = ServicesFactory.getAsignaturasService()
					.findAsignaturasByProfesorId(id).toArray(new Asignatura[0]);
			if (asignaturas.length == 0) {
				asignaturas = null;
			}
			return "listadoProfesores";
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			return "error";
		}
	}
	
	public void iniciaAsignaturas(ActionEvent event) {
		listadoPublico();
	}

	public String listadoPublico() {
		try {
			asignaturas = ServicesFactory.getAsignaturasService()
					.findAllAsignaturas().toArray(new Asignatura[0]);
			return "listadoAsignaturas";
		} catch (BusinessException e) {
			return "error";
		}
	}

	public String delete(Asignatura asignatura) {
		try {
			ServicesFactory.getAsignaturasService().deleteAsignatura(
					asignatura.getId());
		} catch (Exception e) {
			return "error";
		}
		return listadoPublico();
	}

	public String initialize() {
		this.asignatura = new Asignatura();
		asignatura.setCurso(0);
		asignatura.setNombre("my asignatura");
		asignatura.setNumerocreditos("0.0");
		return "/restricted/admin/editAsignatura";
	}

	public void resetAsignatura(ActionEvent event){
		this.asignatura=new Asignatura();

	}
	public String salva() {
		try {
			if (asignatura.getId() == null) {
				ServicesFactory.getAsignaturasService().addAsignatura(
						asignatura);
				listadoPublico();
			} else {
				ServicesFactory.getAsignaturasService().update(asignatura);
			}

			return "ok";
		} catch (BusinessException e) {
			return "error";
		}

	}

}
