package logica;

public class Pasajero {
	private String nombre;
	private int documento;
	
	// Constructor
	Pasajero(String nombre, int documento) {
		this.nombre = nombre;
		this.documento = documento;
	}

	// Getters
	public String getNombre() {
		return this.nombre;
	}

	public int getDocumento() {
		return this.documento;
	}

	// Setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

}
