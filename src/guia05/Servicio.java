package guia05;

import java.time.LocalDate;

public abstract class Servicio implements Contratable{
	
	protected boolean urgente;
	protected LocalDate dia;
	protected int hora_inicio;
	protected int hora_fin;
	protected String oficio;
	protected Trabajador trabajador;
	
	public boolean finalizado() {
		if (hora_fin == 0) {
			return false;
		}else {
			return true;
		}
	}
	
	public float costo() {
		if (urgente) {
			return (float) (trabajador.costo(hora_fin - hora_inicio) * 1.5);
		}else {
			return (trabajador.costo(hora_fin - hora_inicio));
		}
		
	}

	public void trabajador(Trabajador trabaja) {
		if (! trabajador.equals(null)) {
			trabajador = trabaja;
		}else {
			//error
		}
	}

}
