package business.impl;

import java.util.List;

import model.Admin;
import model.exceptions.BusinessException;
import business.AdminService;
import business.impl.admin.FindAllAdministrators;

public class AdminServiceImpl implements AdminService{

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> findAllAdministrators() throws BusinessException {
		// TODO Auto-generated method stub
		return (List<Admin>) new CommandExecuter().execute(new FindAllAdministrators());
	}

}
