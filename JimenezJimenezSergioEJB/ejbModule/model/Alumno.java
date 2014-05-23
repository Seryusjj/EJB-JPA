package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;





@Entity
@DiscriminatorValue("ALUMNO")
public class Alumno extends User{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Alumno() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
