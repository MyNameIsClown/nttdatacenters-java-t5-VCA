package nttdata.javat5.business;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase que implementa las funcionalidades de la interfaz {@link MangmentServiceI}
 * @author Victor Carrasco
 *
 */
public class ManagmentServiceImpl implements ManagmentServiceI{
	/** Logger */
	private static final Logger LOG = LoggerFactory.getLogger(ManagmentServiceImpl.class);
	
	/** simulacion de una base de datos que almacena a los empleados */
	private Map<Integer, Employee> employees;
	
	/**
	 * Constructor
	 */
	public ManagmentServiceImpl() {
		employees= new TreeMap<>();
	}
	
	@Override
	public void register(String name, String category) {
		if(employees.isEmpty()) {
			LOG.info("Registrando al primer empleado");
			employees.put(0, new Employee(0, name, category));
		}else {
			Integer lastId = getLastId()+1;
			employees.put(lastId, new Employee(lastId, name, category));
			LOG.info("Registrando al empleado con id: {}", lastId);
		}
	}
	/**
	 * Este metodo devuelve el id del ultimo empleado registrado en el sistema
	 * @return
	 */
	private Integer getLastId() {
		LOG.debug("Obteniendo el ultimo ID");
		Integer[] idArray = employees.keySet().toArray(new Integer[0]);
		return idArray[idArray.length - 1];
	}

	@Override
	public String showAll() {
		Integer[] idArray = employees.keySet().toArray(new Integer[0]);
		return Arrays.toString(idArray);
	}

	@Override
	public String showDetails(Integer id) {
		Employee employee = employees.get(id);
		return employee.toString();
	}

	@Override
	public Integer count() {
		return employees.size();
	}

}
