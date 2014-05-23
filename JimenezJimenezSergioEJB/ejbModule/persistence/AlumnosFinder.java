package persistence;

import java.util.List;

import model.Alumno;

public class AlumnosFinder {

	public static Alumno findById(Long id) {
		return Jpa.getManager().find(Alumno.class, id);
	}

	public static Alumno findByUserId(String id) {
		return (Alumno) Jpa.getManager()
				.createNamedQuery("Alumnos.findAlumnoById").setParameter(1, id)
				.getSingleResult();
	}

	public static List<Alumno> findAllAlumnos() {
		@SuppressWarnings("unchecked")
		List<Alumno> result = (List<Alumno>) Jpa.getManager()
				.createNamedQuery("Alumnos.findAllAlumnos").getResultList();
		return result;
	}

	public static Alumno findLastAlumno() {
		return (Alumno) Jpa.getManager()
				.createNamedQuery("Alumnos.findLastAlumno").getSingleResult();
		// TODO Auto-generated method stub

	}

}
