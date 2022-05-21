package logic;

import java.sql.*;
import java.util.Scanner;

import handler.ManejadorEstudiante;
import handler.ManejadorMateria;
import handler.ManejadorProfesor;
import handler.ManejadorUsuario;

import persistence.DBConf;
import persistence.ManejadorDB;

public class Main {

	public static void main(String[] args) throws SQLException, InterruptedException {

		DBConf dbconf = new DBConf();
		ManejadorDB mDB = new ManejadorDB();

		Connection con = dbconf.connectMySQL();
		ResultSet rs;

		ManejadorUsuario mUser = new ManejadorUsuario();
		ManejadorEstudiante mEstu = new ManejadorEstudiante();
		ManejadorProfesor mProfe = new ManejadorProfesor();
		ManejadorMateria mMate = new ManejadorMateria();

		Usuario usuario = null;
		Profesor profesor = null;
		Estudiante estudiante = null;
		Materia materia = null;

		Scanner tecInt = new Scanner(System.in);
		Scanner tecString = new Scanner(System.in);

		int opc = 0;

		do {
			System.out.println("--------------------------------------------");
			System.out.println("               Menu principal");
			System.out.println("--------------------------------------------\n");
			System.out.println("  1 > Usuario\n");
			System.out.println("  2 > Alumno\n");
			System.out.println("  3 > Profesor\n");
			System.out.println("  4 > Materia\n");
			System.out.println("  5 > Salir\n");
			System.out.println("--------------------------------------------");

			System.out.println("\n> Ingrese una opcion:\n");
			opc = tecInt.nextInt();

			switch (opc) {
				case 1:
					int codigo;
					String nombre, apellido, nombreMateria;

					do {
						System.out.println("--------------------------------------------");
						System.out.println("                  Usuario");
						System.out.println("--------------------------------------------\n");
						System.out.println("  1 > Crear usuario\n");
						System.out.println("  2 > Modificar usuario\n");
						System.out.println("  3 > Borrar usuario\n");
						System.out.println("  4 > Mostrar usuario\n");
						System.out.println("  5 > Menu principal\n");
						System.out.println("--------------------------------------------\n");

						System.out.println("\n> Ingrese una opcion:\n");
						opc = tecInt.nextInt();

						switch (opc) {
							case 1:
								System.out.println("--------------------------------------------");
								System.out.println("               Crear usuario");
								System.out.println("--------------------------------------------\n");
								System.out.println("> Ingrese su CI:");
								codigo = tecInt.nextInt();

								System.out.println("\n> Ingrese su nombre:");
								nombre = tecString.nextLine();

								System.out.println("\n> Ingrese su apellido:");
								apellido = tecString.nextLine();

								System.out.println("\n--------------------------------------------\n");

								usuario = new Usuario(codigo, nombre, apellido);

								mUser.createUsuario(usuario);
								break;
							case 2:
								System.out.println("--------------------------------------------");
								System.out.println("             Modificar usuario");
								System.out.println("--------------------------------------------\n");
								System.out.println("> Ingrese la CI del usuario a actualizar:");
								codigo = tecInt.nextInt();

								System.out.println("\n> Ingrese el nuevo nombre para el usuario:");
								nombre = tecString.nextLine();

								System.out.println("\n> Ingrese el nuevo apellido para el usuario:");
								apellido = tecString.nextLine();

								System.out.println("\n--------------------------------------------\n");

								mUser.updateUsuario(codigo, nombre, apellido);
								break;
							case 3:
								System.out.println("--------------------------------------------");
								System.out.println("             Borrar usuario");
								System.out.println("--------------------------------------------\n");
								System.out.println("> Ingrese la CI del usuario a borrar:\n");
								codigo = tecInt.nextInt();

								System.out.println("\n--------------------------------------------\n");

								mUser.deleteUsuario(codigo);
								break;
							case 4:
								System.out.println("--------------------------------------------");
								System.out.println("             Mostrar usuario");
								System.out.println("--------------------------------------------\n");
								System.out.println("> Ingrese la CI del usuario a mostrar:");
								codigo = tecInt.nextInt();

								System.out.println("\n--------------------------------------------\n");

								mUser.showUsuario(codigo);
								break;
							case 5:
								break;
							default:
								System.out.println("--------------------------------------------");
								System.out.println("             Opcion invalida");
								System.out.println("--------------------------------------------");

								Thread.sleep(1000);
								break;
						}

					} while (opc != 5);
					opc = 0;
					break;
				case 2:

					do {
						System.out.println("--------------------------------------------");
						System.out.println("                  Estudiante");
						System.out.println("--------------------------------------------\n");
						System.out.println("  1 > Agregar estudiante\n");
						System.out.println("  2 > Mostrar estudiante\n");
						System.out.println("  3 > Agregar materia\n");
						System.out.println("  4 > Mostrar materia\n");
						System.out.println("  5 > Eliminar materia\n");
						System.out.println("  6 > Eliminar estudiante\n");
						System.out.println("  7 > Menu principal\n");
						System.out.println("--------------------------------------------\n");

						System.out.println("\n> Ingrese una opcion:\n");
						opc = tecInt.nextInt();

						switch (opc) {
							case 1:
								System.out.println("--------------------------------------------");
								System.out.println("             Agregar estudiante");
								System.out.println("--------------------------------------------\n");
								System.out.println("> Ingrese la CI del estudiante:");
								codigo = tecInt.nextInt();

								System.out.println("\n--------------------------------------------\n");

								mEstu.createEstudiante(codigo);
								break;
							case 2:
								System.out.println("--------------------------------------------");
								System.out.println("             Mostrar estudiante");
								System.out.println("--------------------------------------------\n");
								System.out.println("> Ingrese la CI del estudiante:");
								codigo = tecInt.nextInt();

								System.out.println("\n--------------------------------------------\n");

								mEstu.showEstudiante(codigo);
								break;
							case 3:
								System.out.println("--------------------------------------------");
								System.out.println("             Agregar materia");
								System.out.println("--------------------------------------------\n");
								System.out.println("> Ingrese la CI del estudiante:");
								codigo = tecInt.nextInt();

								System.out.println("\n> Ingrese el nombre de la materia\n");
								nombreMateria = tecString.nextLine();

								System.out.println("\n--------------------------------------------\n");

								mEstu.addMateria(codigo, nombreMateria);
								break;
							case 4:
								System.out.println("--------------------------------------------");
								System.out.println("             Mostrar materia");
								System.out.println("--------------------------------------------\n");
								System.out.println("> Ingrese la CI del estudiante:");
								codigo = tecInt.nextInt();

								System.out.println("\n--------------------------------------------\n");

								mEstu.showMateria(codigo);
								break;
							case 5:
								System.out.println("--------------------------------------------");
								System.out.println("             Eliminar materia");
								System.out.println("--------------------------------------------\n");
								System.out.println("> Ingrese la CI del estudiante:");
								codigo = tecInt.nextInt();

								System.out.println("\n> Ingrese el nombre de la materia:");
								nombreMateria = tecString.nextLine();

								System.out.println("\n--------------------------------------------\n");

								mEstu.deleteMateria(codigo, nombreMateria);
								break;
							case 6:
								System.out.println("--------------------------------------------");
								System.out.println("             Eliminar estudiante");
								System.out.println("--------------------------------------------\n");
								System.out.println("> Ingrese la CI del estudiante:");
								codigo = tecInt.nextInt();

								System.out.println("\n--------------------------------------------\n");

								mEstu.deleteEstudiante(codigo);
								break;
							case 7:
								break;
							default:
								System.out.println("--------------------------------------------");
								System.out.println("             Opcion invalida");
								System.out.println("--------------------------------------------");

								Thread.sleep(1000);
								break;
						}
					} while (opc != 7);
					break;
				case 3:
					do {
						System.out.println("--------------------------------------------");
						System.out.println("                  Profesor");
						System.out.println("--------------------------------------------\n");
						System.out.println("  1 > Agregar profesor\n");
						System.out.println("  2 > Mostrar profesor\n");
						System.out.println("  3 > Agregar materia\n");
						System.out.println("  4 > Mostrar materia\n");
						System.out.println("  5 > Eliminar materia\n");
						System.out.println("  6 > Eliminar profesor\n");
						System.out.println("  7 > Menu principal\n");
						System.out.println("--------------------------------------------\n");

						opc = tecInt.nextInt();

						switch (opc) {
							case 1:
								System.out.println("--------------------------------------------");
								System.out.println("             Agregar profesor");
								System.out.println("--------------------------------------------\n");
								System.out.println("> Ingrese la CI del profesor:");
								codigo = tecInt.nextInt();

								System.out.println("\n--------------------------------------------\n");

								mProfe.createProfesor(codigo);
								break;
							case 2:
								System.out.println("--------------------------------------------");
								System.out.println("             Mostrar profesor");
								System.out.println("--------------------------------------------\n");
								System.out.println("> Ingrese la CI del profesor:");
								codigo = tecInt.nextInt();

								System.out.println("\n--------------------------------------------\n");

								mProfe.showProfesor(codigo);
								break;
							case 3:
								System.out.println("--------------------------------------------");
								System.out.println("             Agregar materia");
								System.out.println("--------------------------------------------\n");
								System.out.println("> Ingrese la CI del profesor:");
								codigo = tecInt.nextInt();

								System.out.println("\n> Ingrese el nombre de la materia");
								nombreMateria = tecString.nextLine();

								System.out.println("\n--------------------------------------------\n");

								mProfe.addMateria(codigo, nombreMateria);
								break;
							case 4:
								System.out.println("--------------------------------------------");
								System.out.println("             Mostrar materia");
								System.out.println("--------------------------------------------\n");
								System.out.println("> Ingrese la CI del profesor:");
								codigo = tecInt.nextInt();

								System.out.println("\n--------------------------------------------\n");

								mProfe.showMateria(codigo);
								break;
							case 5:
								System.out.println("--------------------------------------------");
								System.out.println("             Eliminar materia");
								System.out.println("--------------------------------------------\n");
								System.out.println("> Ingrese la CI del profesor:");
								codigo = tecInt.nextInt();

								System.out.println("\n> Ingrese el nombre de la materia\n");
								nombreMateria = tecString.nextLine();

								System.out.println("\n--------------------------------------------\n");

								mProfe.deleteMateria(codigo, nombreMateria);
								break;
							case 6:
								System.out.println("--------------------------------------------");
								System.out.println("             Eliminar profesor");
								System.out.println("--------------------------------------------\n");
								System.out.println("> Ingrese la CI del profesor:");
								codigo = tecInt.nextInt();

								System.out.println("\n--------------------------------------------\n");

								mProfe.deleteProfesor(codigo);
								break;
							case 7:
								break;
							default:
								System.out.println("--------------------------------------------");
								System.out.println("             Opcion invalida");
								System.out.println("--------------------------------------------");

								Thread.sleep(1000);
								break;
						}
					} while (opc != 7);

					break;
				case 4:
					do {

						System.out.println("--------------------------------------------");
						System.out.println("                  Materia");
						System.out.println("--------------------------------------------\n");
						System.out.println("  1 > Agregar materia\n");
						System.out.println("  2 > Eliminar materia\n");
						System.out.println("  3 > Mostrar materia\n");
						System.out.println("  4 > Modificar materia\n");
						System.out.println("  5 > Menu principal\n");
						System.out.println("--------------------------------------------\n");

						opc = tecInt.nextInt();

						switch (opc) {
							case 1:
								System.out.println("--------------------------------------------");
								System.out.println("               Agregar materia");
								System.out.println("--------------------------------------------\n");

								System.out.println("> Ingrese su nombre:\n");
								nombre = tecString.nextLine();

								System.out.println("--------------------------------------------\n");

								materia = new Materia(0, nombre);

								mMate.createMateria(materia);
								break;
							case 2:
								System.out.println("--------------------------------------------");
								System.out.println("               Eliminar materia");
								System.out.println("--------------------------------------------\n");

								System.out.println("   > Ingrese su nombre:");
								nombre = tecString.nextLine();

								System.out.println("\n--------------------------------------------\n");

								mMate.deleteMateria(nombre);
								break;
							case 3:
								System.out.println("--------------------------------------------");
								System.out.println("               Mostrar materia");
								System.out.println("--------------------------------------------\n");

								System.out.println("> Ingrese su nombre:\n");
								nombre = tecString.nextLine();

								System.out.println("\n--------------------------------------------\n");

								mMate.showMateria(nombre);
								break;
							case 4:
								System.out.println("--------------------------------------------");
								System.out.println("               Modificar materia");
								System.out.println("--------------------------------------------\n");

								System.out.println("> Ingrese el codigo de la materia:");
								codigo = tecInt.nextInt();

								System.out.println("\n> Ingrese su nuevo nombre:");
								nombre = tecString.nextLine();

								System.out.println("\n--------------------------------------------\n");

								mMate.updateMateria(codigo, nombre);
								break;
							case 5:
								break;
							default:
								System.out.println("--------------------------------------------");
								System.out.println("             Opcion invalida");
								System.out.println("--------------------------------------------");
								Thread.sleep(1000);
								break;
						}
					} while (opc != 5);
					opc = 0;
					break;
				case 5:
					System.out.println("--------------------------------------------");
					System.out.println("             Nos vemos!");
					System.out.println("--------------------------------------------");
					Thread.sleep(1000);
					break;
				default:
					System.out.println("--------------------------------------------");
					System.out.println("             Opcion invalida");
					System.out.println("--------------------------------------------");
					Thread.sleep(1000);
					break;
			}
		} while (opc != 5);
	}

}
