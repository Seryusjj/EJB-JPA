package conf;

import business.AdminService;
import business.AlumnosService;
import business.AsignaturasService;
import business.UserService;
import business.MatriculadosService;
import business.ProfesoresService;



public interface ServicesFactory {
	public  AlumnosService getAlumnosService();

	public  UserService getUserService() ;
	
	public  AdminService getAdminService();
	
	public  ProfesoresService getProfesoresService();
	
	public  AsignaturasService getAsignaturasService();
	
	public  MatriculadosService getMatriculadosService();
}
