package business.impl.asignatura;

import persistence.AsignaturaFinder;
import model.exceptions.BusinessException;
import business.impl.Command;

public class FindAllAsignaturas implements Command{

	@Override
	public Object execute() throws BusinessException {
		return AsignaturaFinder.findAllAsignaturas();
	}

}
