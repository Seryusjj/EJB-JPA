package business.impl;

import java.util.List;

import model.Profesor;
import model.exceptions.BusinessException;
import business.ProfesoresService;
import business.impl.profesor.AddProfesor;
import business.impl.profesor.FindAllProfesores;
import business.impl.profesor.FindProfesorByAsignaturaId;
import business.impl.profesor.FindProfesorById;



public class ProfesorServiceImpl implements ProfesoresService{

	@Override
	public Profesor findById(Long id) throws BusinessException {
		Profesor a = (Profesor) new CommandExecuter().execute(new FindProfesorById(id));
		return  a;
	}

	@Override
	public void addProfesor(Profesor profesor) throws BusinessException {
		new CommandExecuter().execute(new AddProfesor(profesor));
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Profesor> findAllProfesores() throws BusinessException {
		// TODO Auto-generated method stub
		return (List<Profesor>) new CommandExecuter().execute(new FindAllProfesores());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Profesor> findProfesoresByAsignaturaId(Long id)
			throws BusinessException {
		// TODO Auto-generated method stub
		return (List<Profesor>) new CommandExecuter().execute(new FindProfesorByAsignaturaId(id));
	}

}
