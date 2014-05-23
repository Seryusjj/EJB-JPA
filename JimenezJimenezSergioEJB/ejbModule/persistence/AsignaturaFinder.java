package persistence;

import java.util.List;

import model.Asignatura;

public class AsignaturaFinder {
	public static Asignatura findAsignaturaById(Long id) {
		return Jpa.getManager().find(Asignatura.class, id);

	}

	@SuppressWarnings("unchecked")
	public static List<Asignatura> findAllAsignaturas() {
		return Jpa.getManager()
				.createNamedQuery("Asignaturas.findAllAsignaturas")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<Asignatura> findAsignaturasByProfesorId(Long id) {
		return Jpa.getManager()
				.createNamedQuery("Asignaturas.findAsignaturasByProfesorId")
				.setParameter(1, id).getResultList();

	}

}
