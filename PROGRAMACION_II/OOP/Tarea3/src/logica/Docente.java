package logica;

import java.time.LocalDate;

public class Docente extends Usuario {
	// Atributos
	private LocalDate fechaIngreso;

	// Relacion
	private Materia materia;

	// Constructor
	public Docente(String nombre, int ci, LocalDate fechaIngreso, Materia materia) {
		super(nombre, ci);
		this.fechaIngreso = fechaIngreso;
		this.materia = materia;
	}

	// Getters
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public Materia getMateria() {
		return materia;
	}

	// Setters
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

}
