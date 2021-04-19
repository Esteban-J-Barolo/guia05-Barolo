package guia05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Alquiler implements Contratable{
	
	private LocalDate dia_inicio;
	private LocalDate dia_fin;
	private LocalDate dia_entrega;
	private Herramienta herramienta;
	
	public Alquiler(LocalDate dia_inicio, LocalDate dia_fin, Herramienta herramienta) throws HerramientaOcupadaException {
		this.dia_inicio = dia_inicio;
		this.dia_fin = dia_fin;
		if (herramienta.disponible()) {
			herramienta.usar();
		}else {
			//exepcion herra en uso
			throw new HerramientaOcupadaException();
		}
		this.herramienta = herramienta;
	}
	
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
	
	public Alquiler entrega() {
		this.dia_entrega = LocalDate.now();
		herramienta.entregar();
		return this;
	}
	
	public Alquiler clone() {
		return this.clone();
	}

}
