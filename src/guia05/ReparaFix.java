package guia05;

import java.util.ArrayList;

public class ReparaFix {
	ArrayList<Contratable> servicios_disponibles = new ArrayList<>();
	ArrayList<Contratable> servicios_brindados = new ArrayList<>();
	ArrayList<Trabajador> trabajadores = new ArrayList<>();
	ArrayList<Usuario> usuarios = new ArrayList<>();
	
	public float costoServicio(Contratable servicio) {
		
		return servicio.costo();
	}
	
	public float costoServicio(ArrayList<Contratable> servicios) {
		
		return 0;
	}
}
