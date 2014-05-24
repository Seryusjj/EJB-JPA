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

import persistence.Jpa;
import model.Asignatura;
import model.exceptions.BusinessException;
import business.impl.asignatura.AddAsignatura;
import business.impl.asignatura.DeleteAsignatura;
import business.impl.asignatura.FindAllAsignaturas;
import business.impl.asignatura.FindAsignaturaById;
import business.impl.asignatura.FindAsignaturasByProfesorId;
import business.impl.asignatura.Update;
import business.impl.ejbinterfaces.AsignaturasServiceLocal;
import business.impl.ejbinterfaces.AsignaturasServiceRemote;
@Stateless
@TransactionManagement(value=TransactionManagementType.BEAN)
public class AsignaturasServiceImpl implements AsignaturasServiceLocal,AsignaturasServiceRemote {

	@Override
	public Asignatura findAsignaturaById(Long id) throws BusinessException {
		// TODO Auto-generated method stub
		return (Asignatura) commadExecuter(new FindAsignaturaById(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Asignatura> findAllAsignaturas() throws BusinessException {
		 return (List<Asignatura>) commadExecuter(new FindAllAsignaturas());

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Asignatura> findAsignaturasByProfesorId(Long id)
			throws BusinessException {
		// TODO Auto-generated method stub
		return (List<Asignatura>) commadExecuter(new FindAsignaturasByProfesorId(id));
	}

	@Override
	public void update(Asignatura data) throws BusinessException {
		commadExecuter(new Update(data));

	}

	@Override
	public void addAsignatura(Asignatura asignatura) throws BusinessException {
		commadExecuter(new AddAsignatura(asignatura));

	}

	@Override
	public void deleteAsignatura(Long id) throws BusinessException {
		commadExecuter(new DeleteAsignatura(id));

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
