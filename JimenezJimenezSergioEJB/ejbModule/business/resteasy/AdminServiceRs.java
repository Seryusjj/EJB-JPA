package business.resteasy;

import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

import business.AdminService;
import model.Admin;
import model.exceptions.BusinessException;

@Stateless
@Path("/AdminServiceRs")
public interface AdminServiceRs extends AdminService {
	public List<Admin> findAllAdministrators() throws BusinessException;
}
