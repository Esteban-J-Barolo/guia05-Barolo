package guia05;

import java.time.LocalDate;

public abstract class Servicio implements Contratable{
	
	protected boolean urgente;
	protected String oficio;
	protected String nombre;
	
	protected Trabajador trabajador;
	protected LocalDate dia_inicio;
	protected LocalDate dia_fin;
	
	public abstract float costo();
	
	public abstract Servicio comenzar(LocalDate dia_inicio, boolean urgencia, Trabajador trabajador);

	public boolean finalizado(){
		return !(this.dia_fin == null);
	}

	public boolean oficioIgual(String oficio) {
		return this.oficio.equals(oficio);
	}
}
