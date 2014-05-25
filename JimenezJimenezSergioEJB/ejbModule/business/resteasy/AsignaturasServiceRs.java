package business.resteasy;

import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

import business.AsignaturasService;
import model.Asignatura;
import model.exceptions.BusinessException;


@Stateless
@Path("/AsignaturasServiceRs")
public interface AsignaturasServiceRs extends AsignaturasService {
	public Asignatura findAsignaturaById(Long id) throws BusinessException;
	public List<Asignatura> findAllAsignaturas() throws BusinessException;
	public List<Asignatura> findAsignaturasByProfesorId(Long id) throws BusinessException;
	public void update(Asignatura data) throws BusinessException;
	public void addAsignatura(Asignatura asignatura) throws BusinessException;
	public void deleteAsignatura(Long id) throws BusinessException;
}
