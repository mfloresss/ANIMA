package logic;

import java.util.ArrayList;

public class Profesor extends Usuario {
	private int matricula;

	ArrayList<Materia> materia = new ArrayList<Materia>();

	// Constructor
	public Profesor(int ci, String nombre, String apellido, int matricula, ArrayList<Materia> materia) {
		super(ci, nombre, apellido);
		this.matricula = matricula;
		this.materia = materia;
	}
	
	// Getters
	public int getMatricula() {
		return matricula;
	}

	public ArrayList<Materia> getMateria() {
		return materia;
	}
	
	// Setters
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public void setMateria(ArrayList<Materia> materia) {
		this.materia = materia;
	}

}