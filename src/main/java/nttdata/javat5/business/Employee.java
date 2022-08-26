package nttdata.javat5.business;

import java.io.Serializable;
import java.util.Objects;

/**
 * Clase POJO que simula un empleado
 * 
 * @author Victor Carrasco
 *
 */
public class Employee implements Serializable, Comparable<Employee> {
	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	/** id unico que identifica a un empleado */
	private final Integer id;
	/** nombre de un empleado */
	private String name;
	/** categoria de un empleado */
	private String category;
	/** compañia comun a todos los empleados */
	private static final String COMPANY = "NTTdata";

	/**
	 * Name Getter
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Name Setter
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Category getter
	 * 
	 * @return
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Category Setter
	 * 
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * ID Getter
	 * 
	 * @return
	 */
	public Integer getID() {
		return id;
	}

	/**
	 * Company Getter
	 * 
	 * @return
	 */
	public static String getCompany() {
		return COMPANY;
	}

	/**
	 * Constructor
	 * 
	 * @param ID
	 * @param name
	 * @param category
	 */
	public Employee(Integer ID, String name, String category) {
		super();
		this.id = ID;
		this.name = name;
		this.category = category;
	}

	/**
	 * HashCode basado en el ID
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	/**
	 * Equals basado en el ID
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(id, other.id);
	}

	/**
	 * Ordena a los empleados por el ID
	 */
	@Override
	public int compareTo(Employee o) {
		return this.id - o.id;
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", category=" + category + "";
	}
	
	

}
