package business.impl.profesor;

import persistence.ProfesoresFinder;
import model.exceptions.BusinessException;
import business.impl.Command;

public class FindProfesorByAsignaturaId implements Command{
	private Long id;
	
	public FindProfesorByAsignaturaId(Long id){
		this.id=id;
	}

	@Override
	public Object execute() throws BusinessException {
		// TODO Auto-generated method stub
		return ProfesoresFinder.findProfesoresByAsignaturaId(id);
	}

}
