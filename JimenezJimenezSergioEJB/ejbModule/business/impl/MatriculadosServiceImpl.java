package business.impl;

import java.util.List;

import model.Matriculado;
import model.exceptions.BusinessException;
import business.MatriculadosService;

import business.impl.matriculado.AddMatricula;
import business.impl.matriculado.DeleteMatricula;
import business.impl.matriculado.FindMatriculadosByAlumnoId;

public class MatriculadosServiceImpl implements MatriculadosService{

	@SuppressWarnings("unchecked")
	@Override
	public List<Matriculado> findMatriculadosByAlumnoId(Long id)
			throws BusinessException {
		// TODO Auto-generated method stub
		return (List<Matriculado>) new CommandExecuter().execute(new FindMatriculadosByAlumnoId(id));
	}

	@Override
	public void addMatricula(Long alumno, Long asignatura)
			throws BusinessException {
		new CommandExecuter().execute(new AddMatricula(alumno,asignatura));
		
	}

	@Override
	public void delete(Matriculado m) throws BusinessException {
		new CommandExecuter().execute(new DeleteMatricula(m));
		
	}

}
