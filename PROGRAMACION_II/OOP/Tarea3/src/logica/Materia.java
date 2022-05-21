package logica;

public class Materia {
	// Atributos
	private String nombre;

	// Relacion
	private Docente docente;

	public Materia(String nombre, Docente docente) {
		super();
		this.nombre = nombre;
		this.docente = docente;
	}

	// Getters
	public String getNombre() {
		return nombre;
	}

	public Docente getDocente() {
		return docente;
	}

	// Setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

}
