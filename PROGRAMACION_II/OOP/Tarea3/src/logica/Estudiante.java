package logica;

public class Estudiante extends Usuario {
	// Atributos
	private String direccion;

	// Relacion
	private Curso curso;

	// Constructor
	public Estudiante(String nombre, int ci, String direccion, Curso curso) {
		super(nombre, ci);
		this.direccion = direccion;
		this.curso = curso;
	}

	// Getters
	public String getDireccion() {
		return direccion;
	}

	public Curso getCurso() {
		return curso;
	}

	// Setters
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
