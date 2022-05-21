package logica;

public class Main {

	// Imprimir blogs
	public static void printBlogsByAutor(String mailAutor, Blog[] blogs, Usuario[] usuarios) {
		int mailSinBlog = 0;
		for (int i = 0; i < blogs.length; i++) {
			for (int j = 0; j < usuarios.length; j++) {

				if ((blogs[i].getMailAutor().equals(mailAutor)) && (usuarios[j].getMail().equals(mailAutor))) {

					System.out.println(
							"\n    >>> Este es el blog #" + (i + 1) + " “" + blogs[i].getTitulo() + "“ <<< \n");

					System.out.println(blogs[i].getCuerpo() + "\n");
					System.out.println("Creado por: " + usuarios[j].getNombre() + "");
					System.out.println("Mail de contacto: " + usuarios[j].getMail() + "\n");
					System.out.println("-------------------------------------------------------------------------");
				} else {
					mailSinBlog++;
				}
			}
		}
		if ((mailSinBlog == blogs.length * usuarios.length)) {
			System.out.println("   >>> El mail ingresado no contiene ningun Blog <<<");
		}

	}

	public static void main(String[] args) {

		// Atributos
		Usuario[] usuarios = new Usuario[3];
		Blog[] blogs = new Blog[3];

		// Usuarios
		Usuario user1 = new Usuario("Juan", "juan@juan.com", "1234", 1);
		Usuario user2 = new Usuario("Carlos", "carlos@carlos.com", "1234", 2);
		Usuario user3 = new Usuario("Pedro", "pedro@pedro.com", "1234", 2);
		usuarios[0] = user1;
		usuarios[1] = user2;
		usuarios[2] = user3;

		// Blogs
		Blog blog1 = new Blog("Un dia mas en el universo", "Es un libro muy bello, muy entretenido... o no...",
				"juan@juan.com");
		Blog blog2 = new Blog("La divina comedia", "Es un libro muy bello, habla del infierno segun Dante",
				"carlos@carlos.com");
		Blog blog3 = new Blog("El hombre en busca de sentido",
				"Es un libro uy bello, habla de que todos deberiamos tener un sentido de vida", "carlos@carlos.com");
		blogs[0] = blog1;
		blogs[1] = blog2;
		blogs[2] = blog3;

		printBlogsByAutor("pedro@pedro.com", blogs, usuarios);

	}

}
