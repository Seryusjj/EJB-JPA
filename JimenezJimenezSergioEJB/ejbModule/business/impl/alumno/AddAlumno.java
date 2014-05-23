package business.impl.alumno;



import model.Alumno;
import model.exceptions.BusinessException;
import persistence.Jpa;
import business.impl.Command;

public class AddAlumno implements Command{
	private Alumno toInsert;
	public AddAlumno(Alumno alumno) {
		toInsert = alumno;
	}
	
	@Override
	public Object execute() throws BusinessException {
		Jpa.getManager().persist(toInsert);
		return null;
	}

	

}
