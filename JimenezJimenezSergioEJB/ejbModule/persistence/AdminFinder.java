package persistence;

import java.util.List;

import model.Admin;

public class AdminFinder {
	
	public static Admin findByUserId(String id) {
		return (Admin) Jpa.getManager().createNamedQuery("Admin.findlAdminByUserId").setParameter(1, id).getSingleResult();
	}
	public static Admin findById(Long id) {
		return Jpa.getManager().find(Admin.class, id);
	}

	@SuppressWarnings("unchecked")
	public static List<Admin> findAllAdministrators() {
		// TODO Auto-generated method stub
		return Jpa.getManager().createNamedQuery("Admin.findAllAdministrators").getResultList();
	}

}
