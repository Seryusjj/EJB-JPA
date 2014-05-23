package business.impl.matriculado;

import persistence.Jpa;
import persistence.MatriculadosFinder;
import model.Matriculado;
import model.exceptions.BusinessException;
import model.types.MatriculadosKey;
import business.impl.Command;

public class DeleteMatricula implements Command{
	private Matriculado matricula;
	
	public DeleteMatricula(Matriculado matricula){
		this.matricula=matricula;
	}

	@Override
	public Object execute() throws BusinessException {
		Matriculado toRemove = MatriculadosFinder.findMatriculadoById(new MatriculadosKey(matricula.getAsignatura().getId(), matricula.getAlumno().getId()));
		toRemove.unlink();
		//Jpa.getManager().merge(toRemove.getAlumno());
		//Jpa.getManager().merge(toRemove.getAsignatura());
		Jpa.getManager().remove(toRemove);
		

		return null;
	}

}
