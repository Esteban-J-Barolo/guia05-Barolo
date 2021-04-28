package guia05;

import java.time.LocalDate;
import java.util.ArrayList;

import exceptions.AgendaOcupadaException;
import exceptions.HerramientaNoDisponibleException;
import exceptions.HerramientaOcupadaException;
import exceptions.NoHayServicioConEseNombreException;
import exceptions.OficioNoCoincideException;
import exceptions.TrabajadorNoDisponibleException;
import exceptions.UsuarioNoRegistradoException;

public class ReparaFix {
	private ArrayList<ServicioEstandar> servicios_disponibles = new ArrayList<>();
	private ArrayList<Herramienta> herramientas = new ArrayList<>();
	private ArrayList<Trabajador> trabajadores = new ArrayList<>();
	private ArrayList<Usuario> usuarios = new ArrayList<>();
	
	
	
	public void nuevo(ServicioEstandar servicios_disponibles) {
		this.servicios_disponibles.add(servicios_disponibles); 
	}

	public void nuevo(Herramienta herramienta) {
		this.herramientas.add(herramienta);
	}
	
	public void nuevo(Trabajador trabajador) {
		this.trabajadores.add(trabajador);
	}
	
	public void nuevo(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	
	public float costoServicio(Contratable servicio) {
		return servicio.costo();
	}
	
	public float costoServicio(ArrayList<Contratable> servicios) {
		return 0;
	}

	public ServicioEstandar contratar(ServicioEstandar servicio, Boolean urgencia) {
		Servicio serv = servicio;
		try {
			this.contratar(serv, urgencia);
		} catch (TrabajadorNoDisponibleException e) {
			e.printExcepcion();
		}
		return (ServicioEstandar) serv;
	}
	
	public ServicioPersonalizado contratar(String servicio, String oficio, Boolean urgencia){
		Servicio serv = new ServicioPersonalizado(oficio, servicio);
		try {
			this.contratar(serv, urgencia);
		} catch (TrabajadorNoDisponibleException e) {
			e.printExcepcion();
		}
		return (ServicioPersonalizado) serv;
		
	}
	
	private Servicio contratar(Servicio servicio, boolean urgencia)
			throws TrabajadorNoDisponibleException {
		for (Trabajador trabajador : trabajadores) {
			try {
				trabajador.aTrabajar(LocalDate.now(), servicio.comenzar(LocalDate.now(), urgencia, trabajador), urgencia);
				return servicio;
			} catch (AgendaOcupadaException e) {
				//agenda ocupada del trabajador
			} catch (OficioNoCoincideException e) {
				//oficio no coincide
			}
		}//no hay trabajadores disponibles
		throw new TrabajadorNoDisponibleException();
	}
	
	public Alquiler contratar(String herramienta, LocalDate dia_inicial, int cant_dias) throws HerramientaNoDisponibleException {
		for (Herramienta herra : herramientas) {
			if (herra.nombre().equalsIgnoreCase(herramienta)) {
				try {
					return new Alquiler(dia_inicial, dia_inicial.plusDays(cant_dias), herra);
				} catch (HerramientaOcupadaException e) {
					//herramienta ocupada
				}
			}
		}
		throw new HerramientaNoDisponibleException();
	}
	
	public ServicioEstandar buscarServicio(String nomb_servicio) 
			throws NoHayServicioConEseNombreException {
		for (ServicioEstandar serv : servicios_disponibles) {
			if (serv.nombreIgual(nomb_servicio)) return serv.clonar();
		}
		throw new NoHayServicioConEseNombreException();
	}

	public Usuario buscarUsuario(String nombre, String mail) throws UsuarioNoRegistradoException {
		for (Usuario usu : usuarios) {
			if (usu.es(nombre, mail)) return usu;
		}
		throw new UsuarioNoRegistradoException();
	}
}
