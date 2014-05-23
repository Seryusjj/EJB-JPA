package business;

import java.util.List;

import model.User;
import model.exceptions.BusinessException;

public interface UserService {

	public User verify(String name, String password) throws BusinessException;
	
	public List<User> findAllUsers() throws BusinessException;
	
	public void removeUser(Long id) throws BusinessException;


	public void updateUser(User data) throws BusinessException;

}
