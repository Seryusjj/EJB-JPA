package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("PROFESOR")
public class Profesor extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Profesor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
