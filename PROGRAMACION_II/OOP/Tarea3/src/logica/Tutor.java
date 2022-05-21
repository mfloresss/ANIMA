package logica;

public class Tutor extends Usuario {

	// Relacion
	private Usuario[] usuario;

	// Constructor
	public Tutor(String nombre, int ci, Usuario[] usuario) {
		super(nombre, ci);
		this.usuario = usuario;
	}

	// Getters
	public Usuario[] getUsuario() {
		return usuario;
	}

	// Setters
	public void setUsuario(Usuario[] usuario) {
		this.usuario = usuario;
	}

}
