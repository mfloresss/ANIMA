package logica;

public class Usuario {
	// Atributos
	private String nombre;
	private int ci;

	// Constructor
	public Usuario(String nombre, int ci) {
		super();
		this.nombre = nombre;
		this.ci = ci;
	}

	// Getters
	public String getNombre() {
		return nombre;
	}

	public int getCi() {
		return ci;
	}

	// Setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCi(int ci) {
		this.ci = ci;
	}

}
