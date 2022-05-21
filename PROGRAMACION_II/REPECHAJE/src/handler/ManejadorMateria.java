package handler;

import logic.Materia;
import persistence.ManejadorDB;

public class ManejadorMateria {

	static ManejadorDB manejadorDB = new ManejadorDB();

	public void createMateria(Materia Materia) throws InterruptedException {
		manejadorDB.createMateria(Materia);
	}

	public void deleteMateria(String nombre) throws InterruptedException {
		manejadorDB.deleteMateria(nombre);
	}

	public void updateMateria(int codigo, String nombre) throws InterruptedException {
		manejadorDB.updateMateria(codigo, nombre);
	}

	public void showMateria(String nombre) throws InterruptedException {
		manejadorDB.showMateria(nombre);
	}
}
