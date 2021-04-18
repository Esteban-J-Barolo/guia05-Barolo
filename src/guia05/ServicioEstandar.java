package guia05;

public class ServicioEstandar extends Servicio {
	private float precio;
	private String nombre;
	
	@Override
	public float costo() {
		if (urgente) {
			return (float) ((precio + super.costo()) * 1.5);
		}else {
			return (precio + super.costo());
		}
		
	}

}
