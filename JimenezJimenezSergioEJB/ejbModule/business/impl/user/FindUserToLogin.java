package business.impl.user;

import java.util.List;




import persistence.UsuariosFinder;
import model.User;
import model.exceptions.BusinessException;
import business.impl.Command;

public class FindUserToLogin implements Command {

	private String id;
	private String pass;

	public FindUserToLogin(String name, String password) {
		this.id = name;
		this.pass = password;
	}

	@Override
	public Object execute() throws BusinessException {
		
		User result = null;
		List<User> usuarios = UsuariosFinder.findAllUsers();
		for(User u:usuarios){
			if(u.getUser().equals(this.id)&&u.getPass().equals(this.pass)&&u.isActive()){
				result=u;
			}
		}
		
		
		return result;
	}

}
