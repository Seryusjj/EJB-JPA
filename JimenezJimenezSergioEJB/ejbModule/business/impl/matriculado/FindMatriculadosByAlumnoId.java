package business.impl.matriculado;

import persistence.MatriculadosFinder;
import model.exceptions.BusinessException;
import business.impl.Command;

public class FindMatriculadosByAlumnoId implements Command{

	private Long id;
	
	public FindMatriculadosByAlumnoId(Long id){
		this.id=id;
	}
	@Override
	public Object execute() throws BusinessException {
		// TODO Auto-generated method stub
		return MatriculadosFinder.findMatriculadosByAlumnoId(id);
	}

}
