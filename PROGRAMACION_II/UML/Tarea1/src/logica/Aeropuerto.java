package logica;

public class Aeropuerto {
	private int id;
	private String nombre;

	// Constructor
	Aeropuerto(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	// Getters
	public int getId() {
		return this.id;
	}

	public String getNombre() {
		return this.nombre;
	}

	// Setters
	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static void main(String[] args) {
	}

}
