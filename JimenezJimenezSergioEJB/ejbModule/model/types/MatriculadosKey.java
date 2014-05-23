package model.types;

import java.io.Serializable;

public class MatriculadosKey implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long asignatura;
	private Long alumno;
	
	public MatriculadosKey(Long asignatura, Long alumno) {
		super();
		this.asignatura = asignatura;
		this.alumno = alumno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alumno == null) ? 0 : alumno.hashCode());
		result = prime * result
				+ ((asignatura == null) ? 0 : asignatura.hashCode());
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
		MatriculadosKey other = (MatriculadosKey) obj;
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
		return true;
	}

	public MatriculadosKey() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
