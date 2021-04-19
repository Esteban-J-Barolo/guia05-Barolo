package guia05;

import java.time.LocalDate;
import java.util.ArrayList;

public class Trabajador extends Persona {
	private float costo_hora;
	private String oficio;
	private float comision;
	private ArrayList<Servicio> tareas = new ArrayList<>();
	private int horas_max_trabaja;
	
	public Trabajador(String oficio, int horas_max_trabaja, float comision, float costo_hora, String nombre) {
		this.oficio = oficio;
		this.horas_max_trabaja = horas_max_trabaja;
		this.comision = comision;
		this.costo_hora = costo_hora;
		this.nombre = nombre;
	}
	
	public Trabajador(String oficio, int horas_max_trabaja, float comision, float costo_hora, String nombre, String email) {
		this.oficio = oficio;
		this.horas_max_trabaja = horas_max_trabaja;
		this.comision = comision;
		this.costo_hora = costo_hora;
		this.nombre = nombre;
		this.email = email;
	}
	
	public void cobrar(Servicio servicio) {
		System.out.println(this.nombre + " cobra $" + (this.comision/100+1)*servicio.costo());
	}
	
	public float costo(int horas) {
		return (horas * costo_hora);
	}
	
	public Trabajador aTrabajar(LocalDate dia, Servicio servicio) throws AgendaOcupadaException, OficioNoCoincideException {
		if (servicio.oficioIgual(oficio)) {//oficio iguales
				int horas = 0;
				for (Servicio serv : tareas) {//recorrer cada tarea asignada
					if (serv.disponible(dia)) { //verifica que el dia del servicio requerido este diponible
						if (servicio.getClass().isInstance(ServicioEstandar.class)) {//si es un servicio estandar sumar horas
							horas += ((ServicioEstandar) serv).horasDuracion();
						}
					}else {
						// ya esta trabajando
						throw new AgendaOcupadaException();
					}
				}
				//solo estandares
				if (servicio.getClass().isInstance(ServicioEstandar.class)) {
					if (horas + ((ServicioEstandar) servicio).horasDuracion() <= horas_max_trabaja) {//un empleado puede trabajar solo 8 horas al dia
						//puede trabajar
						tareas.add(servicio);
						return this;
					}else {
						// dia no disponible
						throw new AgendaOcupadaException();
					}
				}else {
					//puede trabajar, es personalizado
					tareas.add(servicio);
					return this;
				}
		}else {
			// oficio no coincide
			throw new OficioNoCoincideException();
		}
	}

}
