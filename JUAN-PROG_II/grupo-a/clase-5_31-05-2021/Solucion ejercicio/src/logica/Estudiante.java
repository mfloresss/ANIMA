package logica;

public class Estudiante extends Usuario{
	private String Direcci�n;
	private Curso curso;

	public Estudiante(String nombre, int ci, String direcci�n, Curso curso) {
		super(nombre, ci);
		Direcci�n = direcci�n;
		this.curso = curso;
	}

	public String getDirecci�n() {
		return Direcci�n;
	}

	public void setDirecci�n(String direcci�n) {
		Direcci�n = direcci�n;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
	
	
}
