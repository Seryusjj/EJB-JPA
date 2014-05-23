package business.impl.asignatura;

import persistence.AsignaturaFinder;
import persistence.Jpa;
import model.exceptions.BusinessException;
import business.impl.Command;

public class DeleteAsignatura implements Command{
	private Long id;
	
	public DeleteAsignatura(Long id){
		this.id=id;
	}

	@Override
	public Object execute() throws BusinessException {
		Jpa.getManager().remove(AsignaturaFinder.findAsignaturaById(id));
		return null;
	}

}
