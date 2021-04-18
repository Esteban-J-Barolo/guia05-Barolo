package guia05;

import java.time.LocalDate;
import java.util.ArrayList;

public class Trabajador extends Persona {
	private float costo_hora;
	private String oficio;
	private float comision;
	private ArrayList<Servicio> tareas = new ArrayList<>();
	private int horas_max_tabajadas = 8;
	
	public float costo(int horas) {
		
		return (horas * costo_hora);
	}
	
	//agrega tareas al trabajador
	public Servicio aTrabajar(LocalDate dia, Servicio servicio) {
		if (servicio.oficio.equals(oficio)) {//oficio iguales
			int horas = 0;
			for (Servicio serv : tareas) {//recorrer cada tarea asignada
				if (serv.dia.equals(servicio.dia)) { //verifica que el dia del servicio requerido este diponible
					horas += serv.hora_fin - serv.hora_inicio;
				}
			}
			if (horas <= horas_max_tabajadas) {//un empleado puede trabajar solo 8 horas al dia
				//puede trabajar
				tareas.add(servicio);
				servicio.trabajador(this);
			}else {
				//error dia no disponible
			}
			
		}else {
			//error oficio no coincide
		}
		return servicio;
	}

}
