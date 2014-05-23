package business.impl.profesor;

import persistence.ProfesoresFinder;
import model.exceptions.BusinessException;
import business.impl.Command;

public class FindAllProfesores implements Command{

	@Override
	public Object execute() throws BusinessException {
		// TODO Auto-generated method stub
		return ProfesoresFinder.findAllProfesores();
	}

}
