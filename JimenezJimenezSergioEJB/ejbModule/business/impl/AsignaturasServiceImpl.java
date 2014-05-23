package business.impl;

import java.util.List;

import model.Asignatura;
import model.exceptions.BusinessException;
import business.*;
import business.impl.asignatura.AddAsignatura;
import business.impl.asignatura.DeleteAsignatura;
import business.impl.asignatura.FindAllAsignaturas;
import business.impl.asignatura.FindAsignaturaById;
import business.impl.asignatura.FindAsignaturasByProfesorId;
import business.impl.asignatura.Update;

public class AsignaturasServiceImpl implements AsignaturasService {

	@Override
	public Asignatura findAsignaturaById(Long id) throws BusinessException {
		// TODO Auto-generated method stub
		return (Asignatura) new CommandExecuter()
				.execute(new FindAsignaturaById(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Asignatura> findAllAsignaturas() throws BusinessException {
		// TODO Auto-generated method stub
		return (List<Asignatura>) new CommandExecuter()
				.execute(new FindAllAsignaturas());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Asignatura> findAsignaturasByProfesorId(Long id)
			throws BusinessException {
		// TODO Auto-generated method stub
		return (List<Asignatura>) new CommandExecuter()
				.execute(new FindAsignaturasByProfesorId(id));
	}

	@Override
	public void update(Asignatura data) throws BusinessException {
		new CommandExecuter().execute(new Update(data));

	}

	@Override
	public void addAsignatura(Asignatura asignatura) throws BusinessException {
		new CommandExecuter().execute(new AddAsignatura(asignatura));

	}

	@Override
	public void deleteAsignatura(Long id) throws BusinessException {
		new CommandExecuter().execute(new DeleteAsignatura(id));

	}

}
