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
import model.User;
import model.exceptions.BusinessException;
import business.impl.Command;
import business.impl.user.DeleteUser;
import business.impl.user.FindAllUsers;
import business.impl.user.FindUserToLogin;
import business.impl.user.UpdateUser;


@TransactionManagement(value=TransactionManagementType.BEAN)
public class UserServiceRsImpl implements UserServiceRs {

	@Override
	public User verify(String name, String password) throws BusinessException {

		return (User)  commadExecuter(new FindUserToLogin(name,
				password));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers() throws BusinessException {
		return (List<User>)  commadExecuter(new FindAllUsers());
	}

	@Override
	public void removeUser(Long id) throws BusinessException {
		 commadExecuter(new DeleteUser(id));
		
	}

	@Override
	public void updateUser(User data) throws BusinessException {
		 commadExecuter(new UpdateUser(data));
		
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
