package logic;

public class Usuario {
	private int ci;
	private String nombre, apellido;

	// Constructor
	public Usuario(int ci, String nombre, String apellido) {
		super();
		this.ci = ci;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	// Getters
	public int getCi() {
		return ci;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	// Setters
	public void setCi(int ci) {
		this.ci = ci;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}