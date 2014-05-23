package business.impl.user;


import persistence.Jpa;
import persistence.UsuariosFinder;
import model.User;
import model.exceptions.BusinessException;
import business.impl.Command;

public class DeleteUser implements Command{
	
	private Long id;
	
	public DeleteUser(Long id){
		this.id=id;
	}

	@Override
	public Object execute() throws BusinessException {
		User toRemove = UsuariosFinder.findById(id);
		Jpa.getManager().remove(toRemove);
		return null;
	}
	
	

}
