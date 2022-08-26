package nttdata.javat5;

import nttdata.javat5.business.ManagmentServiceImpl;

/**
 * Clase main
 * @author Victor Carrasco
 *
 */
public class T5MainVCA {
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		ManagmentServiceImpl ms = new ManagmentServiceImpl();
		ms.register("Julian", "Desarrollador");
		ms.register("Julia", "Contable");
		ms.register("Miguel", "RRHH");
		ms.register("Luis", "Desarrollador");
		ms.register("Pepe", "Desarrollador");
		ms.register("Lola", "Desarrollador");
		ms.register("Angela", "RRHH");
		ms.register("Victor", "Gestor");
		ms.register("Hugo", "RRHH");
		ms.register("Alejandro", "Contable");
		ms.register("Roberto", "Contable");
		ms.register("Gonzalo", "RRHH");
		ms.register("Francisco", "Desarrollador");
		
		System.out.println(ms.showAll());
		System.out.println(ms.showDetails(4));
		System.out.println("Numero de empleado registrados: " + ms.count());
		ms.exportXLS();
	}

}
