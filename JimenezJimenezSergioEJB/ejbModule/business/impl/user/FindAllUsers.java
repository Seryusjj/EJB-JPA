package business.impl.user;

import java.util.List;




import persistence.UsuariosFinder;
import model.User;
import model.exceptions.BusinessException;
import business.impl.Command;

public class FindAllUsers implements Command{

	@Override
	public Object execute() throws BusinessException {

		List<User> usr = UsuariosFinder.findAllUsers();
		
		
		return usr;
	}

}
