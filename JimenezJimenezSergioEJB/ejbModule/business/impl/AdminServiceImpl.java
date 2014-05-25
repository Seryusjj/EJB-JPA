package business.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import persistence.Jpa;
import model.Admin;
import model.exceptions.BusinessException;
import business.impl.admin.FindAllAdministrators;
import business.impl.ejbinterfaces.AdminServiceLocal;
import business.impl.ejbinterfaces.AdminServiceRemote;

@Stateless
@WebService(name="AdminService")
@TransactionManagement(value=TransactionManagementType.BEAN)
public class AdminServiceImpl implements AdminServiceLocal,AdminServiceRemote{

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> findAllAdministrators() throws BusinessException {
		// TODO Auto-generated method stub
		return (List<Admin>) commadExecuter(new FindAllAdministrators());
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
