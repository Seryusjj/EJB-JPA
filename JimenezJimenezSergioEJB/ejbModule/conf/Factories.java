package conf;




/**
 * Esta clase es la que realemente relaciona las interfaces de las capas con sus
 * implementaciones finales.
 * 
 * Se toma la configración de un fichero de propiedades de manera que cambiar la
 * configuración de la aplicación (cambiar de implementación en alguna capa)
 * quedará ahora reducido a cambiar el contenido del fichero
 * "factories.properties". Este fichero debe estar en WEB-INF/classes en el WAR
 * final de la aplicación.
 * 
 * Este fichero, para esta implementación debe tener al menos estas dos
 * propiedades SERVICES_FACTORY y PERSISTENCE_FACTORY
 * 
 * Ejemplo:
 * 
 * SERVICES_FACTORY = impl.uo.dasdi.business.SimpleServicesFactory
 * PERSISTENCE_FACTORY = impl.uo.dasdi.persistence.SimplePersistenceFactory
 * 
 * Hay frameworks especializados en esto precisamente, por ejemplo Spring.
 * 
 * @author alb
 * 
 */
public class Factories {
	private static String CONFIG_FILE = "/factories.properties";

	public static ServicesFactory services = (ServicesFactory) 
		FactoriesHelper.createFactory(CONFIG_FILE, "SERVICES_FACTORY");
/*
	public static PersistenceFactory persistence = (PersistenceFactory) 
		FactoriesHelper.createFactory(CONFIG_FILE, "PERSISTENCE_FACTORY");
*/
}
