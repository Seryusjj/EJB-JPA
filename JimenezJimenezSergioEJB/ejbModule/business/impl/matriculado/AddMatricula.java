package business.impl.matriculado;

import persistence.AlumnosFinder;
import persistence.AsignaturaFinder;
import persistence.Jpa;
import business.impl.Command;
import model.Alumno;
import model.Asignatura;
import model.Matriculado;
import model.exceptions.BusinessException;

public class AddMatricula implements Command{
	private Long alumno;
	private Long asigatura;
	
	public AddMatricula(Long alumno,Long asignatura){
		this.alumno=alumno;
		this.asigatura=asignatura;
	}

	@Override
	public Object execute() throws BusinessException {
		Alumno a = AlumnosFinder.findById(alumno);
		Asignatura as = AsignaturaFinder.findAsignaturaById(asigatura);
		@SuppressWarnings("unused")
		Matriculado b = new Matriculado(a,as);//añadae ref a y b
		//Jpa.getManager().persist(b);
		Jpa.getManager().merge(a);
		Jpa.getManager().merge(as);

		return null;
	}

}
