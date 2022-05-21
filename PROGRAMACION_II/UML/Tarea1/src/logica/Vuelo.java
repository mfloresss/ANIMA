package logica;

import java.time.LocalDate;
import java.time.LocalTime;

public class Vuelo {
	private LocalDate fecha;
	private LocalTime hora;
	private Aeropuerto destino, origen;
	private Pasajero[] pasajero;
	private Avion avion;

	// Constructor
	Vuelo(LocalDate fecha, LocalTime hora, Aeropuerto destino, Aeropuerto origen, Pasajero[] pasajero, Avion avion) {
		this.fecha = fecha;
		this.hora = hora;
		this.destino = destino;
		this.origen = origen;
		this.pasajero = pasajero;
		this.avion = avion;
	}

	// Getters
	public LocalDate getFecha() {
		return this.fecha;
	}

	public LocalTime getHora() {
		return this.hora;
	}

	public Aeropuerto getDestino() {
		return this.destino;
	}

	public Aeropuerto getOrigen() {
		return this.origen;
	}

	public Pasajero[] getPasajero() {
		return this.pasajero;
	}

	public Avion getAvion() {
		return this.avion;
	}

	// Setters
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public void setDestino(Aeropuerto destino) {
		this.destino = destino;
	}

	public void setOrigen(Aeropuerto origen) {
		this.origen = origen;
	}

	public void setPasajero(Pasajero[] pasajero) {
		this.pasajero = pasajero;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

}
