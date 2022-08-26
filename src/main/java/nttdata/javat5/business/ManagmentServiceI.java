package nttdata.javat5.business;

/**
 * Interfaz encargada de la gestion de Empleados
 * 
 * @author Victor Carrasco
 *
 */
public interface ManagmentServiceI {
	/**
	 * Registra a los empleados en la base de datos, se asigna automaticamente un ID
	 * 
	 * @param name
	 * @param category
	 */
	public void register(String name, String category);

	/**
	 * Devuelve una cadena de texto con todos los ID de los empleados
	 * 
	 * @return
	 */
	public String showAll();

	/**
	 * Muestra la informacion del empleado con el ID pasado por parametro
	 * 
	 * @param ID
	 * @return
	 */
	public String showDetails(Integer id);

	/**
	 * Devuelve la cantidad de empleados dados de alta en el sistema
	 * 
	 * @return
	 */
	public Integer count();
}
