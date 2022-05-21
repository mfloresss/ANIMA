package logic;

import java.util.ArrayList;

public class Estudiante extends Usuario {
	private int nroEstudiante;
	ArrayList<Materia> materia = new ArrayList<Materia>();

	// Constructor
	public Estudiante(int ci, String nombre, String apellido, int nroEstudiante, ArrayList<Materia> materia) {
		super(ci, nombre, apellido);
		this.nroEstudiante = nroEstudiante;
		this.materia = materia;
	}
	
	// Getters 
	public int getNroEstudiante() {
		return nroEstudiante;
	}

	public ArrayList<Materia> getMateria() {
		return materia;
	}
	
	// Setters 
	public void setNroEstudiante(int nroEstudiante) {
		this.nroEstudiante = nroEstudiante;
	}

	public void setMateria(ArrayList<Materia> materia) {
		this.materia = materia;
	}

}