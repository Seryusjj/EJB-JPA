package business.impl.profesor;

import persistence.Jpa;
import business.impl.Command;
import model.Profesor;
import model.exceptions.BusinessException;

public class AddProfesor implements Command{
	private Profesor toInsert;

	public AddProfesor(Profesor profesor) {
		this.toInsert = profesor;
	}

	@Override
	public Object execute() throws BusinessException {
		Jpa.getManager().persist(toInsert);
		return null;
	}

}
