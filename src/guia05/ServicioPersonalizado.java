package guia05;

public class ServicioPersonalizado extends Servicio {
	private float valor_presupuestado;
	private float costo_materiales;
	private float costo_transporte;
	
	@Override
	public float costo() {
		if (urgente) {
			return (float) ((valor_presupuestado + costo_materiales + costo_transporte + super.costo()) * 1.5);
		}else {
			return (valor_presupuestado + costo_materiales + costo_transporte + super.costo());
		}
		
	}
	
}
