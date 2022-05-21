package handler;

import persistence.ManejadorDB;

public class ManejadorEstudiante {
	ManejadorDB manejadorDB = new ManejadorDB();

	public void createEstudiante(int ci) throws InterruptedException {
		manejadorDB.createEstudiante(ci);
	}

	public void deleteEstudiante(int ci) throws InterruptedException {
		manejadorDB.deleteEstudiante(ci);
	}

	public void showEstudiante(int ci) throws InterruptedException {
		manejadorDB.showEstudiante(ci);
	}

	public void addMateria(int ci, String nombreMateria) throws InterruptedException {
		manejadorDB.addMateriaEstu(ci, nombreMateria);
	}

	public void deleteMateria(int ci, String nombreMateria) throws InterruptedException {
		manejadorDB.deleteMateriaEstu(ci, nombreMateria);
	}

	public void showMateria(int ci) throws InterruptedException {
		manejadorDB.showMateriaEstu(ci);
	}
}
