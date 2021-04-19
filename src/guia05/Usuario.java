package guia05;

import java.util.ArrayList;

public class Usuario extends Persona {
	private int tarjeta;
	private ReparaFix empresa;
	private ArrayList<Contratable> contratado = new ArrayList<>();
	
	public Usuario(String nombre, String email, int tarjeta, ReparaFix empresa) {
		this.nombre = nombre;
		this.email = email;
		this.tarjeta = tarjeta;
		this.empresa = empresa;
	}
	
	public void pagar() {
		System.out.println("Pagado con tarjeta N°: " + this.tarjeta);
	}
	
	public void contratar(Servicio servicio) {
		Servicio servClone = servicio.clone();
		try {
			contratado.add(empresa.contratar(servClone));
		} catch (TrabajadorNoDisponibleException e) {
			e.printExcepcion();
		}
		
	}
	
	public void contratar(Alquiler servicio) 
			throws AlquilerNoEntregadoException {
		Alquiler alqClone = servicio.clone();
		int cant = 0;
		for (Contratable alquiler : contratado) {
			if(alquiler.getClass().isInstance(Alquiler.class)) cant++;
		}
		if (cant > 2) {
			//excepcion ya tiene el maximo de alquileres posibles
			throw new AlquilerNoEntregadoException();
		}else {
			try {
				contratado.add(empresa.contratar(alqClone));
			} catch (TrabajadorNoDisponibleException e) {
				e.printExcepcion();
			}
		}
	}

}
