package business.impl.asignatura;

import persistence.Jpa;
import model.Asignatura;
import model.exceptions.BusinessException;
import business.impl.Command;

public class AddAsignatura implements Command{
	
	private Asignatura toInsert;
	
	public AddAsignatura(Asignatura toInsert){
		this.toInsert=toInsert;
	}

	@Override
	public Object execute() throws BusinessException {
		Jpa.getManager().persist(toInsert);
		return null;
	}

}
