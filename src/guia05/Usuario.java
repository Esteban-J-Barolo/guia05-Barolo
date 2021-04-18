package guia05;

import java.util.ArrayList;

public class Usuario extends Persona {
	private int tarjeta;
	private ArrayList<Contratable> contratado = new ArrayList<>();
	
	public void contratar(Contratable algo) {
		if(algo.getClass().isInstance(new Alquiler())) {
			int cant = 0;
			for (Contratable alqiler : contratado) {
				if(algo.getClass().isInstance(new Alquiler())) {
					cant++;
				}
			}
			if (cant < 3) {
				//error ya tiene el maximo de alquileres posibles
			}else {
				contratado.add(algo);
			}
		}else {
			contratado.add(algo);
		}
		
	}

}
