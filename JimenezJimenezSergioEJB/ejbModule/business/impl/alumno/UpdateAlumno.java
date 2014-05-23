package business.impl.alumno;

import persistence.AlumnosFinder;
import persistence.Jpa;
import model.Alumno;
import model.exceptions.BusinessException;
import business.impl.Command;

public class UpdateAlumno implements Command{
	private Long id;
	private Alumno data;
	
	public UpdateAlumno(Alumno alumno){
		this.id=alumno.getId();
		this.data=alumno;
	}

	@Override
	public Object execute() throws BusinessException {
		
		Alumno toUpdate = AlumnosFinder.findById(id);
        toUpdate.setActive(data.isActive());
        toUpdate.setMail(data.getMail());
        toUpdate.setName(data.getName());
        toUpdate.setPass(data.getPass());
        toUpdate.setSurname(data.getSurname());
        Jpa.getManager().merge(toUpdate);	
		return null;
	}

}
