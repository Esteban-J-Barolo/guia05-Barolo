package guia05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Alquiler implements Contratable{
	
	private LocalDate dia_inicio;
	private LocalDate dia_fin;
	private LocalDate dia_entrega;
	private Herramienta herramienta;
	
	@Override
	public float costo() {
		
		return (herramienta.costo() * ChronoUnit.DAYS.between(dia_inicio, dia_entrega));
	}
	
	public boolean enMora() {
		
		if (dia_entrega.equals(null)) {
			return dia_fin.isBefore(LocalDate.now());
		}else {
			return dia_fin.isBefore(dia_entrega);
		}
	}
	
	public boolean finalizado() {
		
		return !(dia_entrega.equals(null));
	}

}
