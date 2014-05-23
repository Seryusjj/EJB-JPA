package conf;

import business.AdminService;
import business.AlumnosService;
import business.AsignaturasService;
import business.UserService;
import business.MatriculadosService;
import business.ProfesoresService;
import business.impl.AdminServiceImpl;
import business.impl.AlumnosServiceImpl;
import business.impl.AsignaturasServiceImpl;
import business.impl.UserServiceImpl;
import business.impl.MatriculadosServiceImpl;
import business.impl.ProfesorServiceImpl;


public class ServicesFactory {
	public static AlumnosService getAlumnosService() {
		return new AlumnosServiceImpl();
	}

	public static UserService getUserService() {
		// TODO Auto-generated method stub
		return new UserServiceImpl();
	}
	
	public static AdminService getAdminService(){
		return new AdminServiceImpl();
	}
	
	public static ProfesoresService getProfesoresService(){
		return new ProfesorServiceImpl();
		
	}
	
	public static AsignaturasService getAsignaturasService(){
		return new AsignaturasServiceImpl();
	}
	
	public static MatriculadosService getMatriculadosService(){
		return new MatriculadosServiceImpl();
	}
}
