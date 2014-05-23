package model.types;

import java.io.Serializable;

public class ImparteKey implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long asignatura;
	private Long profesor;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((profesor == null) ? 0 : profesor.hashCode());
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
		ImparteKey other = (ImparteKey) obj;
		if (profesor == null) {
			if (other.profesor != null)
				return false;
		} else if (!profesor.equals(other.profesor))
			return false;
		if (asignatura == null) {
			if (other.asignatura != null)
				return false;
		} else if (!asignatura.equals(other.asignatura))
			return false;
		return true;
	}

	public ImparteKey() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
