package business.impl.asignatura;

import persistence.AsignaturaFinder;
import persistence.Jpa;
import model.Asignatura;
import model.exceptions.BusinessException;
import business.impl.Command;

public class Update implements Command{
	private Asignatura data;
	
	public Update(Asignatura data){
		this.data=data;
	}

	@Override
	public Object execute() throws BusinessException {
		Asignatura toUpdate = AsignaturaFinder.findAsignaturaById(data.getId());
		toUpdate.setCurso(data.getCurso());
		toUpdate.setNombre(data.getNombre());
		toUpdate.setNumerocreditos(data.getNumerocreditos());
		Jpa.getManager().merge(toUpdate);
		return null;
	}

}
