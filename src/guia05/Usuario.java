package guia05;

import java.time.LocalDate;
import java.util.ArrayList;

import exceptions.AlquilerNoEntregadoException;
import exceptions.HerramientaNoDisponibleException;

public class Usuario extends Persona {
	private int tarjeta;
	private ReparaFix empresa;
	private ArrayList<Contratable> contratado = new ArrayList<>();
	
	public Usuario(String nombre, String mail, int tarjeta, ReparaFix empresa) {
		this.nombre = nombre;
		this.mail = mail;
		this.tarjeta = tarjeta;
		this.empresa = empresa;
	}
	
	public void pagar() {
		int cost=0;
		for (Contratable serv : contratado) {
			cost += serv.costo();
		}
		System.out.println("$" + cost + " Pagado con tarjeta N°: " + this.tarjeta);
	}
	
	public void contratar(String servicio, String oficio, Boolean urgencia) {
		contratado.add(empresa.contratar( servicio,  oficio,  urgencia));
	}
	
	public void contratar(ServicioEstandar servicio, Boolean urgencia) {
		contratado.add(empresa.contratar( servicio,  urgencia));
	}
	
	public void contratar(String herramienta, LocalDate dia_inicial, int cant_dias) 
			throws AlquilerNoEntregadoException {
		int cant = 0;
		for (Contratable alquiler : contratado) {
			if(alquiler.getClass() == Alquiler.class ) cant++;
		}
		if (cant >= 2) {
			//excepcion ya tiene el maximo de alquileres posibles
			throw new AlquilerNoEntregadoException();
		}else {
			try {
				contratado.add(empresa.contratar(herramienta, dia_inicial, cant_dias));
			} catch (HerramientaNoDisponibleException e) {
				e.printExcepcion();
			}
		}
	}

	public boolean es(String nombre, String mail) {
		return (this.nombre.equals(nombre) && this.mail.equals(mail));
	}

}
