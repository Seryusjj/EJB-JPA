package business;

import java.util.List;

import model.Asignatura;
import model.exceptions.BusinessException;

public interface AsignaturasService {
	public Asignatura findAsignaturaById(Long id) throws BusinessException;
	public List<Asignatura> findAllAsignaturas() throws BusinessException;
	public List<Asignatura> findAsignaturasByProfesorId(Long id) throws BusinessException;
	public void update(Asignatura data) throws BusinessException;
	public void addAsignatura(Asignatura asignatura) throws BusinessException;
	public void deleteAsignatura(Long id) throws BusinessException;
}
