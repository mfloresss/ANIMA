package logica;

public class Curso {
	// Atributos
	private String nombre;

	// Relacion
	private Materia[] materia;

	public Curso(String nombre, Materia[] materia) {
		super();
		this.nombre = nombre;
		this.materia = materia;
	}
	
	//Getters
	public String getNombre() {
		return nombre;
	}

	public Materia[] getMateria() {
		return materia;
	}
	
	//Setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setMateria(Materia[] materia) {
		this.materia = materia;
	}

}
