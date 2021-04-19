package guia05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class prue {
	public static void main(String[] args) {
		ReparaFix empresa = new ReparaFix();
		empresa.add(new ServicioEstandar("Carpintero", "silla", 4, 1200));
		empresa.add(new ServicioEstandar("Carpintero", "mesa", 6, 2200));
		empresa.add(new Trabajador("Carpintero", 8, 20, 50, "Nigga"));
		empresa.add(new Trabajador("Carpintero", 8, 10, 500, "Jose"));
		empresa.add(new Trabajador("Panadero", 8, 20, 50, "Alejandra"));
		Usuario a1 = new Usuario("Jorge", "asds@sda.com", 1520, empresa);
		Usuario a2 = new Usuario("Maria", "ass@sda.com", 15204658, empresa);
		empresa.add(a1);
		empresa.add(a2);
		
	}

}
