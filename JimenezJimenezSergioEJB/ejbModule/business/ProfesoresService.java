package business;

import java.util.List;

import model.Profesor;
import model.exceptions.BusinessException;

public interface ProfesoresService {
	public Profesor findById(Long id) throws BusinessException;

	public void addProfesor(Profesor profesor) throws BusinessException;

	public List<Profesor> findAllProfesores() throws BusinessException;

	public List<Profesor> findProfesoresByAsignaturaId(Long id) throws BusinessException;

}
