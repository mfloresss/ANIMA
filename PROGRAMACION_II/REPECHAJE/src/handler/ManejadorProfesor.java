package handler;

import persistence.ManejadorDB;

public class ManejadorProfesor {
	ManejadorDB manejadorDB = new ManejadorDB();

	public void createProfesor(int ci) throws InterruptedException {
		manejadorDB.createProfesor(ci);
	}

	public void deleteProfesor(int ci) throws InterruptedException {
		manejadorDB.deleteProfesor(ci);
	}

	public void showProfesor(int ci) throws InterruptedException {
		manejadorDB.showProfesor(ci);
	}

	public void addMateria(int ci, String nombreMateria) throws InterruptedException {
		manejadorDB.addMateriaProfe(ci, nombreMateria);
	}

	public void deleteMateria(int ci, String nombreMateria) throws InterruptedException {
		manejadorDB.deleteMateriaProfe(ci, nombreMateria);
	}

	public void showMateria(int ci) throws InterruptedException {
		manejadorDB.showMateriaProfe(ci);
	}
}
