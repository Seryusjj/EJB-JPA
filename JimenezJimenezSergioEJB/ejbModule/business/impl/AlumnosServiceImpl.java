package business.impl;

import java.util.List;

import model.Alumno;
import model.exceptions.BusinessException;
import business.AlumnosService;
import business.impl.alumno.DeleteAlumno;
import business.impl.alumno.FindAllAlumnos;


public class AlumnosServiceImpl implements AlumnosService{



	@Override
	public void deleteAlumno(Long id) throws BusinessException {
		new CommandExecuter().execute(new DeleteAlumno(id));
		
	}

	@Override
	public void updateAlumno( Alumno data) throws BusinessException {
		new CommandExecuter().execute(new business.impl.alumno.UpdateAlumno(data));
		
	}

	@Override
	public void addAlumno(Alumno alumno) throws BusinessException {
		new CommandExecuter().execute(new business.impl.alumno.AddAlumno(alumno));
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Alumno> findAllAlumnos() throws BusinessException {
		
		return (List<Alumno>) new CommandExecuter().execute(new FindAllAlumnos());
		
	}

}
