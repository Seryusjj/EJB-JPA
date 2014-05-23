package business;

import java.util.List;

import model.Matriculado;
import model.exceptions.BusinessException;

public interface MatriculadosService {
	public List<Matriculado> findMatriculadosByAlumnoId(Long user) throws BusinessException;

	public void addMatricula(Long alumno, Long asignatura) throws BusinessException;

	public void delete(Matriculado m) throws BusinessException;
}
