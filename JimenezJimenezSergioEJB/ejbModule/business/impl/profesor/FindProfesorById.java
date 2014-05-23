package business.impl.profesor;


import persistence.ProfesoresFinder;
import model.exceptions.BusinessException;
import business.impl.Command;

public class FindProfesorById implements Command{

	private Long id;
	public FindProfesorById(Long id){
		this.id=id;
	}
	@Override
	public Object execute() throws BusinessException {
		
		return ProfesoresFinder.findById(id);
	}

}
