package business.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import model.Alumno;
import model.exceptions.BusinessException;
import persistence.Jpa;
import business.impl.alumno.DeleteAlumno;
import business.impl.alumno.FindAllAlumnos;
import business.impl.ejbinterfaces.AlumnosServiceLocal;
import business.impl.ejbinterfaces.AlumnosServiceRemote;

@Stateless
@TransactionManagement(value=TransactionManagementType.BEAN)
public class AlumnosServiceImpl implements AlumnosServiceLocal,AlumnosServiceRemote{



	@Override
	public void deleteAlumno(Long id) throws BusinessException {
		commadExecuter(new DeleteAlumno(id));
		
	}

	@Override
	public void updateAlumno( Alumno data) throws BusinessException {
		commadExecuter(new business.impl.alumno.UpdateAlumno(data));
		
	}

	@Override
	public void addAlumno(Alumno alumno) throws BusinessException {
		commadExecuter(new business.impl.alumno.AddAlumno(alumno));
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Alumno> findAllAlumnos() throws BusinessException {
		Object result = commadExecuter(new FindAllAlumnos());
		return (List<Alumno>) result;
		
	}
	
	/**
	 * Como queremos que las transacciones sean manejadas programaticamente añadimos:
	 * @TransactionManagement(value=TransactionManagementType.BEAN) e 
	 * indicamos que desde este metodo se puede hacer commit rollback ...etc 
	 * @param command
	 * @return
	 * @throws BusinessException
	 */
	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	private Object commadExecuter(Command command) throws BusinessException{
		EntityManager em = Jpa.createEntityManager();
		EntityTransaction trx = em.getTransaction();
		trx.begin();
		Object result = null;
		try {
			result = command.execute();
			trx.commit(); 
		} catch (PersistenceException e) {

			if (trx.isActive()) {
				trx.rollback();
			}
			throw e;
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		return result;
		
	}

}
