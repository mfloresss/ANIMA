package logic;

public class Materia {
	private int codigo;
	private String nombre;

	// Constructor
	public Materia(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}

	// Getters
	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	// Setters
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}