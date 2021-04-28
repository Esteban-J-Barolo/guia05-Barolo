package guia05;

import java.time.LocalDate;
import java.util.ArrayList;

import exceptions.AgendaOcupadaException;
import exceptions.OficioNoCoincideException;

public class Trabajador extends Persona {
	private float costo_hora;
	private String oficio;
	private float comision;
	private ArrayList<Servicio> tareas = new ArrayList<>();
	
	public Trabajador(String oficio, float comision, float costo_hora, String nombre) {
		this.oficio = oficio;
		this.comision = comision;
		this.costo_hora = costo_hora;
		this.nombre = nombre;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public void cobrar(Servicio servicio) {
		System.out.println(this.nombre + " cobra $" + (this.comision/100+1)*servicio.costo());
	}
	
	public float costo(int horas) {
		return (horas * costo_hora);
	}
	
	public Trabajador aTrabajar(LocalDate dia, Servicio servicio, boolean urgencia) 
			throws AgendaOcupadaException, OficioNoCoincideException {
		if (servicio.oficioIgual(oficio)) {//oficio iguales
			if (this.diaDisponible(dia)) { //verifica que el dia del servicio requerido este diponible
				tareas.add(servicio);
				return this;
			}else {
				// ya esta trabajando
				throw new AgendaOcupadaException();
			}
		}else {
			// oficio no coincide
			throw new OficioNoCoincideException();
		}
	}
	
	private boolean diaDisponible(LocalDate dia) {
		for (Servicio serv : tareas) {
			if(! serv.finalizado()) return false;
		}
		return true;
	}

}
