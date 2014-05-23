package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

import model.types.ImparteKey;




@Entity
@IdClass(ImparteKey.class)
public class Imparte implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne
	private User profesor;
	@Id
	@ManyToOne
	private Asignatura asignatura;

	
	public Imparte(User p, Asignatura as) {
		super();
		this.profesor = p;
		this.asignatura = as;
		profesor._getImparte().add(this);
		asignatura._getImparte().add(this);
	}
	

	
	public void unlink() {
		profesor._getImparte().remove(this);
		asignatura._getImparte().remove(this);
		profesor= null;
		asignatura = null;
	}

	


	public User getProfesor() {
		return profesor;
	}



	public Imparte() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((asignatura == null) ? 0 : asignatura.hashCode());
		result = prime * result
				+ ((profesor == null) ? 0 : profesor.hashCode());
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
		Imparte other = (Imparte) obj;
		if (asignatura == null) {
			if (other.asignatura != null)
				return false;
		} else if (!asignatura.equals(other.asignatura))
			return false;
		if (profesor == null) {
			if (other.profesor != null)
				return false;
		} else if (!profesor.equals(other.profesor))
			return false;
		return true;
	}

	
	
	

}
