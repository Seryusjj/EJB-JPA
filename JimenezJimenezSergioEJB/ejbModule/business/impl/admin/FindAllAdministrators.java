package business.impl.admin;

import persistence.AdminFinder;
import model.exceptions.BusinessException;
import business.impl.Command;

public class FindAllAdministrators implements Command{

	@Override
	public Object execute() throws BusinessException {
		// TODO Auto-generated method stub
		return AdminFinder.findAllAdministrators();
	}

}
