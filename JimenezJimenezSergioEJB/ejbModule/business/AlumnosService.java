package business;

import java.util.List;

import model.Alumno;
import model.exceptions.BusinessException;



public interface AlumnosService {

	public void deleteAlumno(Long id) throws BusinessException;
	public void updateAlumno(Alumno data)throws BusinessException;
	public void addAlumno(Alumno alumno) throws BusinessException;
	public List<Alumno> findAllAlumnos() throws BusinessException;


}
