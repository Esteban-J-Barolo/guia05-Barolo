package prueba;

import java.time.LocalDate;

import exceptions.AlquilerNoEntregadoException;
import exceptions.NoHayServicioConEseNombreException;
import exceptions.UsuarioNoRegistradoException;

import guia05.*;

public class prue {
	public static void main(String[] args) throws NoHayServicioConEseNombreException, UsuarioNoRegistradoException {
		
		ReparaFix empresa = new ReparaFix();
		Usuario usuario;
		
		empresa.nuevo(new ServicioEstandar("Carpintero", "silla", 4, 1200));
		empresa.nuevo(new ServicioEstandar("Carpintero", "mesa", 6, 2200));
		empresa.nuevo(new ServicioEstandar("Herrero", "mesa", 5, 3200));
		empresa.nuevo(new ServicioEstandar("Eelectricista", "cambiar llave", 6, 200));
		empresa.nuevo(new ServicioEstandar("Eelectricista", "reparar cables", 6, 500));
		
		empresa.nuevo(new Herramienta("acha", 50));
		empresa.nuevo(new Herramienta("acha", 50));
		empresa.nuevo(new Herramienta("soldadora", 350));
		empresa.nuevo(new Herramienta("escalera", 150));
		empresa.nuevo(new Herramienta("escalera", 150));
		empresa.nuevo(new Herramienta("escalera", 150));
		empresa.nuevo(new Herramienta("escalera", 150));
		empresa.nuevo(new Herramienta("escalera", 150));
		
		empresa.nuevo(new Trabajador("Carpintero", 20, 50, "Migga"));
		empresa.nuevo(new Trabajador("Carpintero", 10, 500, "Jose"));
		empresa.nuevo(new Trabajador("Carpintero", 15, 70, "Maria"));
		empresa.nuevo(new Trabajador("Herrero", 20, 50, "Alejandra"));
		empresa.nuevo(new Trabajador("Eelectricista", 30, 360, "Fernando"));
		empresa.nuevo(new Trabajador("Eelectricista", 60, 100, "Jose"));
		
		empresa.nuevo(new Usuario("Jorge", "asds@sda.com", 1520, empresa));
		empresa.nuevo(new Usuario("Maria", "ass@sda.com", 15204658, empresa));
		
		usuario = empresa.buscarUsuario("Jorge","asds@sda.com");
		usuario.contratar("hacer casa", "Carpintero", false);
		usuario.contratar(empresa.buscarServicio("silla"), false);
		usuario.contratar(empresa.buscarServicio("silla"), false);
		try {
			usuario.contratar("escalera", LocalDate.now(), 3);
			usuario.contratar("escalera", LocalDate.now(), 3);
		} catch (AlquilerNoEntregadoException e1) {
			e1.printExcepcion();
		}
		//usuario.pagar();
		
		usuario = empresa.buscarUsuario("Maria","ass@sda.com");
		usuario.contratar(empresa.buscarServicio("silla"), true);
		
		try {
			usuario.contratar("escalera", LocalDate.now(), 2);
			usuario.contratar("escalera", LocalDate.now(), 3);
			usuario.contratar("escalera", LocalDate.now(), 4);
			usuario.contratar("escalera", LocalDate.now(), 4);
		} catch (AlquilerNoEntregadoException e) {
			e.printExcepcion();
		}
		
		/*
		Alquiler n = new Alquiler(LocalDate.now(), LocalDate.now().plusDays(3), new Herramienta("pelus", 20));
		if( n.getClass() == Alquiler.class ) System.out.println("siii");
		*/
	}

}
