package handler;

import logic.Usuario;
import persistence.ManejadorDB;

public class ManejadorUsuario {
	ManejadorDB manejadorDB = new ManejadorDB();

	public void createUsuario(Usuario usuario) throws InterruptedException {
		manejadorDB.createUsuario(usuario);
	}

	public void deleteUsuario(int ci) throws InterruptedException {
		manejadorDB.deleteUsuario(ci);
	}

	public void updateUsuario(int ci, String nombre, String apellido) throws InterruptedException {
		manejadorDB.updateUsuario(ci, nombre, apellido);
	}

	public void showUsuario(int ci) throws InterruptedException {
		manejadorDB.showUsuario(ci);
	}

}
