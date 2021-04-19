package guia05;

import java.time.LocalDate;
import java.util.ArrayList;

public class ReparaFix {
	private ArrayList<Servicio> servicios_disponibles = new ArrayList<>();
	private ArrayList<Herramienta> herramientas = new ArrayList<>();
	private ArrayList<Trabajador> trabajadores = new ArrayList<>();
	private ArrayList<Usuario> usuarios = new ArrayList<>();
	
	private ArrayList<Contratable> servicios_brindados = new ArrayList<>();
	
	
	public void add(Servicio servicios_disponibles) {
		this.servicios_disponibles.add(servicios_disponibles); 
	}

	public void add(Herramienta herramienta) {
		this.herramientas.add(herramienta);
	}
	
	public void add(Trabajador trabajador) {
		this.trabajadores.add(trabajador);
	}
	
	public void add(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	
	public float costoServicio(Contratable servicio) {
		return servicio.costo();
	}
	
	public float costoServicio(ArrayList<Contratable> servicios) {
		return 0;
	}

	public Contratable contratar(Contratable tarea) throws TrabajadorNoDisponibleException {
		if (tarea.getClass().isInstance(Servicio.class)) {
			
			for (Trabajador trabajador : trabajadores) {
				
				Servicio servicio = ((Servicio)tarea).comenzar(LocalDate.now(), false, trabajador);
				if (!(servicio.equals(null))) {
					
					servicios_brindados.add(servicio);
					return ((Contratable)servicio);
					
				}
				
			}
			//no hay trabajadores disponibles
			throw new TrabajadorNoDisponibleException();
			
		}else {//es un alquiler
			
			servicios_brindados.add(tarea);
			return tarea;
			
		}
	}
}
