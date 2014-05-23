package business.impl.alumno;

import persistence.AlumnosFinder;
import model.exceptions.BusinessException;
import business.impl.Command;

public class FindAllAlumnos implements Command{

	@Override
	public Object execute() throws BusinessException {
		// TODO Auto-generated method stub
		return AlumnosFinder.findAllAlumnos();
	}

}
