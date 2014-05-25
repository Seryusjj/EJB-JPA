package business.resteasy;

import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import persistence.Jpa;
import model.Profesor;
import model.exceptions.BusinessException;
import business.impl.Command;
import business.impl.profesor.AddProfesor;
import business.impl.profesor.FindAllProfesores;
import business.impl.profesor.FindProfesorByAsignaturaId;
import business.impl.profesor.FindProfesorById;



@TransactionManagement(value=TransactionManagementType.BEAN)
public class ProfesorServiceRsImpl implements ProfesoresServiceRs{

	@Override
	public Profesor findById(Long id) throws BusinessException {
		Profesor a = (Profesor) commadExecuter(new FindProfesorById(id));
		return  a;
	}

	@Override
	public void addProfesor(Profesor profesor) throws BusinessException {
		commadExecuter(new AddProfesor(profesor));
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Profesor> findAllProfesores() throws BusinessException {
		// TODO Auto-generated method stub
		return (List<Profesor>)  commadExecuter(new FindAllProfesores());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Profesor> findProfesoresByAsignaturaId(Long id)
			throws BusinessException {
		// TODO Auto-generated method stub
		return (List<Profesor>)  commadExecuter(new FindProfesorByAsignaturaId(id));
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
