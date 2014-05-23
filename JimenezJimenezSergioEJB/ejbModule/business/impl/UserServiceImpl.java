package business.impl;

import java.util.List;

import model.User;
import model.exceptions.BusinessException;
import business.UserService;
import business.impl.user.DeleteUser;
import business.impl.user.FindAllUsers;
import business.impl.user.FindUserToLogin;
import business.impl.user.UpdateUser;

public class UserServiceImpl implements UserService {

	@Override
	public User verify(String name, String password) throws BusinessException {

		return (User) new CommandExecuter().execute(new FindUserToLogin(name,
				password));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers() throws BusinessException {
		return (List<User>) new CommandExecuter().execute(new FindAllUsers());
	}

	@Override
	public void removeUser(Long id) throws BusinessException {
		new CommandExecuter().execute(new DeleteUser(id));
		
	}

	@Override
	public void updateUser(User data) throws BusinessException {
		new CommandExecuter().execute(new UpdateUser(data));
		
	}
	
	

}
