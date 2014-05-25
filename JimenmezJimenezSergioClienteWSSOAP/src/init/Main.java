package init;

import java.util.List;

import ws.alumnos.Alumno;
import ws.alumnos.AlumnosService;
import ws.alumnos.AlumnosServiceImplService;





/**
 * La libreria de hibernate debe estar en el classpath pues trabajamos con jpa y
 * los objetos transferidos solo osn entendidos por hibernate
 * 
 * @author Sergio
 * 
 */
public class Main {

	public static void main(String[] args) {
		Main main = new Main();

		try {

			main.run();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("\n-- ejb remote client ended --");
	}

	private void run() throws Exception {

		AlumnosService alumnosService = new AlumnosServiceImplService().getAlumnosServicePort();

		List<Alumno> alumnos = alumnosService.findAllAlumnos();

		printHeader();
		for (Alumno a : alumnos) {
			printLine(a);
		}
	}

	private void printHeader() {
		System.out.printf("%s %s %s %s\n", "_APELLIDOS__________",
				"_NOMBRE________", "_EMAIL___________________", "_IDUSER_");
	}

	private void printLine(Alumno a) {
		System.out.printf("%-20s %-15s %-25s %-8s\n", a.getSurname(),
				a.getName(), a.getMail(), a.getUser());
	}

}
