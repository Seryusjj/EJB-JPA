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
import model.Matriculado;
import model.exceptions.BusinessException;
import business.impl.Command;
import business.impl.matriculado.AddMatricula;
import business.impl.matriculado.DeleteMatricula;
import business.impl.matriculado.FindMatriculadosByAlumnoId;


@TransactionManagement(value=TransactionManagementType.BEAN)
public class MatriculadosServiceRsImpl implements MatriculadosServiceRs{

	@SuppressWarnings("unchecked")
	@Override
	public List<Matriculado> findMatriculadosByAlumnoId(Long id)
			throws BusinessException {
		// TODO Auto-generated method stub
		return (List<Matriculado>) commadExecuter(new FindMatriculadosByAlumnoId(id));
	}

	@Override
	public void addMatricula(Long alumno, Long asignatura)
			throws BusinessException {
		commadExecuter(new AddMatricula(alumno,asignatura));
		
	}

	@Override
	public void delete(Matriculado m) throws BusinessException {
		commadExecuter(new DeleteMatricula(m));
		
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
