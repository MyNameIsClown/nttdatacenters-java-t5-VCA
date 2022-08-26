package nttdata.javat5.business;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
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
	
	/** File */
	private final File file = new File("./Files/employees.xls");
	/**
	 * Constructor
	 */
	public ManagmentServiceImpl() {
		employees= new TreeMap<>();
		try {
			file.createNewFile();
		} catch (IOException e) {
			LOG.error(e.toString());
		}
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
	/**
	 * Este metodo vuelca la informacion en un archivo excel
	 */
	public void exportXLS() {
		int count = 0;
		Collection<Employee> employeesTemp = employees.values();
		try (Workbook wb = new HSSFWorkbook()) {
			Sheet sh = wb.createSheet("Hoja_01");
			for(Employee e: employeesTemp) {
				Row r = sh.createRow(count);
				//Se almacena el id del empleado e
				Cell cId = r.createCell(0);
				cId.setCellValue(e.getID());
				//Se almacena el nombre del empleado e
				Cell cName = r.createCell(1);
				cName.setCellValue(e.getName());
				//Se almacena la categoria del empleado e
				Cell cCategory = r.createCell(2);
				cCategory.setCellValue(e.getCategory());
				//Se incrementa la fila
				count++;
			}
			FileOutputStream fos = new FileOutputStream(file);
			wb.write(fos);
		} catch (IOException e) {
			LOG.error(e.toString());
		}
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
