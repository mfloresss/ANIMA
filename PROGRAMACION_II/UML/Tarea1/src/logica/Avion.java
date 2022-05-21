package logica;

public class Avion {
	private String modelo;
	private String patente;
	private int capacidad;

	// Constructor
	Avion(String modelo, String patente, int capacidad) {
		this.modelo = modelo;
		this.patente = patente;
		this.capacidad = capacidad;
	}

	// Getters
	public String getModelo() {
		return this.modelo;
	}

	public String getPatente() {
		return this.patente;
	}

	public int getCapacidad() {
		return this.capacidad;
	}

	// Setters
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
}
