package persistence;

import java.util.List;

import model.User;

public class UsuariosFinder {
	@SuppressWarnings("unchecked")
	public static List<User> findAllUsers(){
		return Jpa.getManager().createNamedQuery("User.findAllUser").getResultList();
	}
	
	public static User findById(Long id){
		return Jpa.getManager().find(User.class, id);
	}

}
