package business.impl.alumno;

import persistence.AlumnosFinder;
import persistence.Jpa;
import model.Alumno;
import model.exceptions.BusinessException;
import business.impl.Command;

public class DeleteAlumno implements Command{

	private Long id;
	
	public DeleteAlumno(Long id){
		this.id=id;
	}
	@Override
	public Object execute() throws BusinessException {
		Alumno toDelete = AlumnosFinder.findById(id);
		Jpa.getManager().remove(toDelete);
		return null;
	}

}
