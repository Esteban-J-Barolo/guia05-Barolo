package guia05;

import java.time.LocalDate;

public abstract class Servicio implements Contratable{
	
	protected boolean urgente;
	protected String oficio;
	protected String nombre;
	
	protected Trabajador trabajador;
	protected LocalDate dia_inicio;
	protected LocalDate dia_fin;
	
	public Servicio clone() {
		return this.clone();
	}
	
	public abstract float costo();
	
	public boolean finalizado(){
		
		return !(dia_fin.equals(null));
	}

	public boolean oficioIgual(String oficio) {
		
		return this.oficio.equals(oficio);
	}
	
	public abstract Servicio comenzar(LocalDate dia_inicio, boolean urgencia, Trabajador trabajador);
	
	public boolean disponible(LocalDate dia){
		if (this.finalizado()) {
			return !(this.dia_inicio.isBefore(dia) && this.dia_fin.isAfter(dia));
		}else {
			return false;
		}
	}

}
