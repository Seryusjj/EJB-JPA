package business;

import java.util.List;

import model.Admin;
import model.exceptions.BusinessException;

public interface AdminService {
	public List<Admin> findAllAdministrators() throws BusinessException;
}
