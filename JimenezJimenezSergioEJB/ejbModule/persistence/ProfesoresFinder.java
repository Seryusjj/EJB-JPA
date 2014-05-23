package persistence;

import java.util.List;

import model.Profesor;



public class ProfesoresFinder {
	public static Profesor findByUserId(String id) {
		return (Profesor) Jpa.getManager().createNamedQuery("").setParameter(1, id).getSingleResult();
	}
	public static Profesor findById(Long id) {
		return Jpa.getManager().find(Profesor.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public static List<Profesor> findAllProfesores(){
		return Jpa.getManager().createNamedQuery("Profesores.findAllProfesores").getResultList();
	}

	public static Object findProfesoresByAsignaturaId(Long id) {
		// TODO Auto-generated method stub
		return Jpa.getManager().createNamedQuery("Profesores.findProfesoresByAsignaturaId").setParameter(1, id).getResultList();
	}
	

}
