package exceptions;

public class TrabajadorNoDisponibleException extends Exception {

	public void printExcepcion() {
		System.out.println("No hay trabajadores disponibles");
		
	}
}
