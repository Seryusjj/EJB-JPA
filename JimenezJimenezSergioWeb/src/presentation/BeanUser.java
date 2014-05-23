package presentation;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import conf.ServicesFactory;
import model.Admin;
import model.User;
import model.exceptions.BusinessException;

@ManagedBean(name = "user_controller")
@SessionScoped
public class BeanUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private User user;
	private User[] users;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User[] getUsers() {
		return users;
	}

	public void setUsers(User[] users) {
		this.users = users;
	}

	
	public String gestionUsusarios() {
		users = null;
		try {
			LinkedList<User> resultado = new LinkedList<User>();
			List<User> resultado1 = ServicesFactory.getUserService()
					.findAllUsers();
			for (User usr : resultado1) {
				if (!(usr instanceof Admin)) {
					if (!usr.isActive()) {
						resultado.add(usr);
					}
				}
			}
			for (User usr : resultado1) {
				if (!(usr instanceof Admin)) {

					if (usr.isActive()) {
						resultado.add(usr);
					}
				}
			}
			this.users = resultado.toArray(new User[0]);
			return "/restricted/admin/gestionUsuarios";
		} catch (BusinessException e) {
			return "error";
		}
	}

	public String bajaUsuarios(Long id) {
		try {
			ServicesFactory.getUserService().removeUser(id);
			return gestionUsusarios();
		} catch (BusinessException e) {
			return "error";
		}
	}

	public String update() {
		try {
			ServicesFactory.getUserService().updateUser(user);
			gestionUsusarios();
			return "/restricted/admin/gestionUsuarios";
		} catch (BusinessException e) {
			return "error";
		}
	}
	
	
	public void toggle(User user) {
		try {
			if(user.isActive()){
				user.setActive(false);
			}else{
				user.setActive(true);
			}
			ServicesFactory.getUserService().updateUser(user);
			gestionUsusarios();

		} catch (BusinessException e) {
			
		}
	}

}
