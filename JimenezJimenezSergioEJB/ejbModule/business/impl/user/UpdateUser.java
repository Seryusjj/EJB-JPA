package business.impl.user;

import persistence.UsuariosFinder;
import model.User;
import model.exceptions.BusinessException;
import business.impl.Command;

public class UpdateUser implements Command{

	private User data;
	
	public UpdateUser(User data){
		this.data=data;
	}
	@Override
	public Object execute() throws BusinessException {
		User toUpdate= UsuariosFinder.findById(data.getId());
		toUpdate.setActive(data.isActive());
		toUpdate.setMail(data.getMail());
		toUpdate.setName(data.getName());
		toUpdate.setPass(data.getPass());
		toUpdate.setSurname(data.getSurname());
		return null;
	}

}
