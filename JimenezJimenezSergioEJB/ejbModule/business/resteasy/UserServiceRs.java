package business.resteasy;

import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import business.UserService;
import model.User;
import model.exceptions.BusinessException;

@Stateless
@Path("/UserServiceRs")
public interface UserServiceRs extends UserService {
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<User> findAllUsers() throws BusinessException;

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("{name,password}")
	public User verify(@PathParam("name")String name,@PathParam("password") String password) throws BusinessException;



	@DELETE
	@Path("{id}")
	public void removeUser(@PathParam("id")Long id) throws BusinessException;


	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void updateUser(User data) throws BusinessException;

}
