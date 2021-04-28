package guia05;

public class Herramienta {
	private String nombre;
	private int costo_dia;
	private boolean disponible=true;
	
	public Herramienta(String nombre, int costo) {
		this.nombre = nombre;
		this.costo_dia = costo;
	}
	
	public int costo() {
		
		return costo_dia;
	}
	
	public void usar() {
		this.disponible=false;
	}
	
	public void entregar() {
		this.disponible=true;
	}
	
	public boolean disponible() {
		return disponible;
	}

	public String nombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

}
