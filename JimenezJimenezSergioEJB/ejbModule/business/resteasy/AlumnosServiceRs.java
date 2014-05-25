package business.resteasy;

import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

import business.AlumnosService;
import model.Alumno;
import model.exceptions.BusinessException;


@Stateless
@Path("/AlumnosServiceRs")
public interface AlumnosServiceRs extends AlumnosService {

	public void deleteAlumno(Long id) throws BusinessException;
	public void updateAlumno(Alumno data)throws BusinessException;
	public void addAlumno(Alumno alumno) throws BusinessException;
	public List<Alumno> findAllAlumnos() throws BusinessException;


}
