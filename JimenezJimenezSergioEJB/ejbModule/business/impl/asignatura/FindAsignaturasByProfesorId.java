package business.impl.asignatura;

import persistence.AsignaturaFinder;
import model.exceptions.BusinessException;
import business.impl.Command;

public class FindAsignaturasByProfesorId implements Command{
	private Long id;
	public FindAsignaturasByProfesorId(Long id){
		this.id=id;
	}

	@Override
	public Object execute() throws BusinessException {
		// TODO Auto-generated method stub
		return AsignaturaFinder.findAsignaturasByProfesorId(id);
	}

}
