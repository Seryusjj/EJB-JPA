package business.impl.alumno;

import persistence.AlumnosFinder;
import model.exceptions.BusinessException;
import business.impl.Command;

public class FindAlumnoById implements Command{

	private String id;
	public FindAlumnoById(String id){
		this.id=id;
	}
	@Override
	public Object execute() throws BusinessException {
		
		return AlumnosFinder.findByUserId(id);
	}

}
