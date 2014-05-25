package business.resteasy;

import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

import business.MatriculadosService;
import model.Matriculado;
import model.exceptions.BusinessException;

@Stateless
@Path("/MatriculadosServiceRs")
public interface MatriculadosServiceRs extends MatriculadosService {
	public List<Matriculado> findMatriculadosByAlumnoId(Long user) throws BusinessException;

	public void addMatricula(Long alumno, Long asignatura) throws BusinessException;

	public void delete(Matriculado m) throws BusinessException;
}
