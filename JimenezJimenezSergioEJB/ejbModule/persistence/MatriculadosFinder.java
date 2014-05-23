package persistence;

import java.util.List;

import model.Matriculado;
import model.types.MatriculadosKey;

public class MatriculadosFinder {
	public static Matriculado findMatriculadoById(MatriculadosKey id) {
		return Jpa.getManager().find(Matriculado.class, id);
		
	}

	@SuppressWarnings("unchecked")
	public static List<Matriculado> findMatriculadosByAlumnoId(Long id) {
		// TODO Auto-generated method stub
		return Jpa.getManager()
				.createNamedQuery("Matriculados.findMatriculaodsByAlumnoId")
				.setParameter(1, id).getResultList();
	}

}
