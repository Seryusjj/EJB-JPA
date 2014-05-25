package business.resteasy;

import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

import business.ProfesoresService;
import model.Profesor;
import model.exceptions.BusinessException;


@Stateless
@Path("/ProfesoresServiceRs")
public interface ProfesoresServiceRs extends ProfesoresService {
	public Profesor findById(Long id) throws BusinessException;

	public void addProfesor(Profesor profesor) throws BusinessException;

	public List<Profesor> findAllProfesores() throws BusinessException;

	public List<Profesor> findProfesoresByAsignaturaId(Long id) throws BusinessException;

}
