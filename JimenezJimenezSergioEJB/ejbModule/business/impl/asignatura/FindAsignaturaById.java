package business.impl.asignatura;

import persistence.AsignaturaFinder;
import model.exceptions.BusinessException;
import business.impl.Command;

public class FindAsignaturaById implements Command{
	private Long id;
	
	public FindAsignaturaById(Long id){
		this.id=id;
	}

	@Override
	public Object execute() throws BusinessException {
		// TODO Auto-generated method stub
		return AsignaturaFinder.findAsignaturaById(id);
	}

}
