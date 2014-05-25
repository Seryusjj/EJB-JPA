package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import model.types.MatriculadosKey;



@Entity
@XmlRootElement(name = "matriculados")
@IdClass(MatriculadosKey.class)
public class Matriculado implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne
	private User alumno;
	@Id
	@ManyToOne
	private Asignatura asignatura;
	
	private String calificacion;
	
	@Transient
	private boolean canBeDeleted;
	
	/**
	 * La relacion podra ser eliminada siempre que no este calificada
	 * @return
	 */
	@XmlTransient
	public boolean isCanBeDeleted() {
		canBeDeleted=calificacion.equals("no-calificado");
		return canBeDeleted;
	}

	public void setCanBeDeleted(boolean canBeDeleted) {
		this.canBeDeleted = canBeDeleted;
	}

	
	
	@XmlElement
	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}

	public void setAlumno(User alumno) {
		this.alumno = alumno;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Matriculado() {
		super();
	}

	public  Matriculado(User a, Asignatura as) {
		super();
		this.alumno = a;
		this.asignatura = as;
		this.calificacion = "no-calificado";
		alumno._getMatriculados().add(this);
		asignatura._getMatriculados().add(this);
	}
	
	public  Matriculado(User a, Asignatura as,String calificacion) {
		super();
		this.alumno = a;
		this.asignatura = as;
		this.calificacion = calificacion;
		alumno._getMatriculados().add(this);
		asignatura._getMatriculados().add(this);
	}
	
	public void unlink() {
		alumno._getMatriculados().remove(this);
		asignatura._getMatriculados().remove(this);
		alumno= null;
		asignatura = null;
	}

	@XmlElement
	public User getAlumno() {
		return alumno;
	}

	@XmlElement
	public Asignatura getAsignatura() {
		return asignatura;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alumno == null) ? 0 : alumno.hashCode());
		result = prime * result
				+ ((asignatura == null) ? 0 : asignatura.hashCode());
		result = prime * result
				+ ((calificacion == null) ? 0 : calificacion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matriculado other = (Matriculado) obj;
		if (alumno == null) {
			if (other.alumno != null)
				return false;
		} else if (!alumno.equals(other.alumno))
			return false;
		if (asignatura == null) {
			if (other.asignatura != null)
				return false;
		} else if (!asignatura.equals(other.asignatura))
			return false;
		if (calificacion == null) {
			if (other.calificacion != null)
				return false;
		} else if (!calificacion.equals(other.calificacion))
			return false;
		return true;
	}
	
	

}
