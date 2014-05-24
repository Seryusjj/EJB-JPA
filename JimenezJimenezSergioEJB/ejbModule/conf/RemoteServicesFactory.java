package conf;

import javax.naming.*;

import business.*;



public class RemoteServicesFactory implements ServicesFactory{

	private static final String ALUMNOS_SERVICE_JNDI_KEY = 
			"ejb:"
			+ "JimenezJimenezSergioEAR/"
			+ "JimenezJimenezSergioEJB/"
			+ "AlumnosServiceImpl!"
			+ "business.impl.ejbinterfaces.AlumnosServiceRemote";
	
	private static final String USER_SERVICE_JNDI_KEY = 
			"ejb:"
			+ "JimenezJimenezSergioEAR/"
			+ "JimenezJimenezSergioEJB/"
			+ "UserServiceImpl!"
			+ "business.impl.ejbinterfaces.UserServiceRemote";
	
	private static final String ADMIN_SERVICE_JNDI_KEY = 
			"ejb:"
			+ "JimenezJimenezSergioEAR/"
			+ "JimenezJimenezSergioEJB/"
			+ "AdminServiceImpl!"
			+ "business.impl.ejbinterfaces.AdminServiceRemote";
	
	private static final String PROFESOR_SERVICE_JNDI_KEY = 
			"ejb:"
			+ "JimenezJimenezSergioEAR/"
			+ "JimenezJimenezSergioEJB/"
			+ "ProfesorServiceImpl!"
			+ "business.impl.ejbinterfaces.ProfesorServiceRemote";
	
	private static final String ASIGNATURAS_SERVICE_JNDI_KEY = 
			"ejb:"
			+ "JimenezJimenezSergioEAR/"
			+ "JimenezJimenezSergioEJB/"
			+ "AsignaturasServiceImpl!"
			+ "business.impl.ejbinterfaces.AsignaturasServiceRemote";
	
	private static final String MATRICULADOS_SERVICE_JNDI_KEY = 
			"ejb:"
			+ "JimenezJimenezSergioEAR/"
			+ "JimenezJimenezSergioEJB/"
			+ "MatriculadosServiceImpl!"
			+ "business.impl.ejbinterfaces.MatriculadosServiceRemote";


	@Override
	public AlumnosService getAlumnosService() {
		try {
			Context ctx = new InitialContext();
			return (AlumnosService) ctx.lookup(ALUMNOS_SERVICE_JNDI_KEY);

		} catch (NamingException e) {
			throw new RuntimeException("JNDI problem", e);
		}
	}

	@Override
	public UserService getUserService() {
		try {
			Context ctx = new InitialContext();
			return (UserService) ctx.lookup(USER_SERVICE_JNDI_KEY);

		} catch (NamingException e) {
			throw new RuntimeException("JNDI problem", e);
		}
	}

	@Override
	public AdminService getAdminService() {
		try {
			Context ctx = new InitialContext();
			return (AdminService) ctx.lookup(ADMIN_SERVICE_JNDI_KEY);

		} catch (NamingException e) {
			throw new RuntimeException("JNDI problem", e);
		}
	}

	@Override
	public ProfesoresService getProfesoresService() {
		try {
			Context ctx = new InitialContext();
			return (ProfesoresService) ctx.lookup(PROFESOR_SERVICE_JNDI_KEY);

		} catch (NamingException e) {
			throw new RuntimeException("JNDI problem", e);
		}
	}

	@Override
	public AsignaturasService getAsignaturasService() {
		try {
			Context ctx = new InitialContext();
			return (AsignaturasService) ctx.lookup(ASIGNATURAS_SERVICE_JNDI_KEY);

		} catch (NamingException e) {
			throw new RuntimeException("JNDI problem", e);
		}
	}

	@Override
	public MatriculadosService getMatriculadosService() {
		try {
			Context ctx = new InitialContext();
			return (MatriculadosService) ctx.lookup(MATRICULADOS_SERVICE_JNDI_KEY);

		} catch (NamingException e) {
			throw new RuntimeException("JNDI problem", e);
		}
	}

}
