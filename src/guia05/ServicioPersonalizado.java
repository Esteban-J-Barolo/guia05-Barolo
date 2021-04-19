package guia05;

import java.time.LocalDate;

public class ServicioPersonalizado extends Servicio {
	private float valor_presupuestado;
	private float costo_materiales;
	private float costo_transporte;
	
	public ServicioPersonalizado(String oficio,String nombre) {
		this.oficio = oficio;
		this.nombre = nombre;
	}
	
	@Override
	public float costo() {
		if (urgente) {
			return (float) ((valor_presupuestado + costo_materiales + costo_transporte) * 1.5);
		}else {
			return (valor_presupuestado + costo_materiales + costo_transporte);
		}
	}
	
	public ServicioPersonalizado comenzar(LocalDate dia_inicio, boolean urgencia, Trabajador trabajador) {
		this.dia_inicio = dia_inicio;
		this.urgente = urgencia;
		try {
			this.trabajador = trabajador.aTrabajar(dia_inicio, this);
		} catch (AgendaOcupadaException e) {
			e.printExcepcion();
		} catch (OficioNoCoincideException e) {
			e.printExcepcion();
		}
		return this;
	}
	
	public ServicioPersonalizado finalizar(LocalDate dia_fin, float valor_presupuestado, float costo_materiales, float costo_transporte) {
		this.dia_fin = dia_fin;
		this.valor_presupuestado = valor_presupuestado;
		this.costo_materiales = costo_materiales;
		this.costo_transporte = costo_transporte;
		return this;
	}
	
}
