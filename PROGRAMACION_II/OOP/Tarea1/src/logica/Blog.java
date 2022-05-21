package logica;

public class Blog {
	// Atributos
	String titulo;
	String cuerpo;
	String mailAutor;

	// Constructor
	Blog(String titulo, String cuerpo, String mailAutor) {
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		this.mailAutor = mailAutor;
	}

	// Getters
	public String getTitulo() {
		return this.titulo;
	}

	public String getCuerpo() {
		return this.cuerpo;
	}

	public String getMailAutor() {
		return this.mailAutor;
	}

	// Setters
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	public void setMailAutor(String mailAutor) {
		this.mailAutor = mailAutor;
	}

}
