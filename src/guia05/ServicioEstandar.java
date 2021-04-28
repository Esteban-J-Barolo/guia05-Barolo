package guia05;

import java.time.LocalDate;

public class ServicioEstandar extends Servicio {
	private float precio;
	private int horas_empleadas;
	
	public ServicioEstandar(String oficio, String nombre, int duracion, int precio) {
		this.oficio = oficio;
		this.nombre = nombre;
		this.precio = precio;
		this.horas_empleadas = duracion;
	}
	
	
	@Override
	public float costo() {
		if (urgente) {
			return (float) ((precio + trabajador.costo(horas_empleadas)) * 1.5);
		}else {
			return (precio + trabajador.costo(horas_empleadas));
		}
		
	}
	
	public int horasDuracion() {
		return (horas_empleadas);
	}
	
	public ServicioEstandar comenzar(LocalDate dia_inicio, boolean urgencia, Trabajador trabajador) {
		this.dia_inicio = dia_inicio;
		this.urgente = urgencia;
		this.trabajador = trabajador;
		return this;
	}
	
	public void finalizar(LocalDate dia_fin, int horas_empleadas) {
		this.dia_fin = dia_fin;
		this.horas_empleadas = horas_empleadas;
	}
	
	public boolean nombreIgual(String nombre) {
		return this.nombre.equals(nombre);
	}
	
	public ServicioEstandar clonar() {
		return new ServicioEstandar(oficio, nombre, horas_empleadas, horas_empleadas);
	}
}
