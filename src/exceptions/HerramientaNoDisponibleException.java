package exceptions;

public class HerramientaNoDisponibleException extends Exception {
	public void printExcepcion() {
		System.out.println("No hay herramienta disponible para alquilar.");
		
	}
}
