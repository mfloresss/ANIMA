package persistence;

import java.sql.*;

import logic.Materia;
import logic.Usuario;

public class ManejadorDB {
	DBConf dbconf = new DBConf();
	Connection con = dbconf.connectMySQL();
	ResultSet rs;

	public void createUsuario(Usuario usuario) throws InterruptedException {
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT ci FROM Usuario WHERE ci = " + usuario.getCi() + ";";
			rs = stmt.executeQuery(query);

			if (rs.next() == false) {
				String insert = "INSERT INTO Usuario VALUES(" + usuario.getCi() + ", '" + usuario.getNombre() + "', '" + usuario.getApellido() + "');";
				stmt.executeUpdate(insert);

				System.out.println("--------------------------------------------");
				System.out.println("Se creo el usuario " + usuario.getNombre() + " con exito");
				System.out.println("--------------------------------------------");

				Thread.sleep(1000);
			} else {
				System.out.println("--------------------------------------------");
				System.out.println("El usuario " + usuario.getNombre() + " ya existe");
				System.out.println("--------------------------------------------");
				
				Thread.sleep(1000);
			}

		} catch (SQLException e) {
			System.out.println("--------------------------------------------------------------------------------------");
			System.out.println("Hubo un error al crear el usuario " + usuario.getNombre() + ", intente nuevamente");
			System.out.println("--------------------------------------------------------------------------------------");

			Thread.sleep(1000);
		}
	}

	public void deleteUsuario(int ci) throws InterruptedException {
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT ci FROM Usuario WHERE ci = " + ci + ";";
			rs = stmt.executeQuery(query);

			if (rs.next() != false) {
				String insert = "DELETE FROM Usuario WHERE ci = " + ci + ";";
				stmt.executeUpdate(insert);

				System.out.println("----------------------------------------------------------");
				System.out.println("Se borro el Usuario con la CI " + ci + " correctamente");
				System.out.println("----------------------------------------------------------");

				Thread.sleep(1000);
			} else {
				System.out.println("--------------------------------------------");
				System.out.println("El usuario con la CI " + ci + " no existe");
				System.out.println("--------------------------------------------");

				Thread.sleep(1000);
			}

		} catch (SQLException e) {
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("Hubo un error al borrar el usuario con la CI " + ci + ", intente nuevamente");
			System.out.println("--------------------------------------------------------------------------------");

			Thread.sleep(1000);
		}
	}

	public void updateUsuario(int ci, String nombre, String apellido) throws InterruptedException {
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT ci FROM Usuario WHERE ci = " + ci + ";";
			rs = stmt.executeQuery(query);

			if (rs.next() != false) {
				String insert = "UPDATE Usuario SET nombre = '" + nombre + "', apellido = '" + apellido + "' WHERE ci = " + ci + ";";
				stmt.executeUpdate(insert);

				System.out.println("--------------------------------------------------------------------------------");
				System.out.println("Se actualizaron los datos del usuario con la CI " + ci + " correctamente");
				System.out.println("--------------------------------------------------------------------------------");

				Thread.sleep(1000);

			} else {
				System.out.println("--------------------------------------------");
				System.out.println("El usuario con la CI " + ci + " no existe");
				System.out.println("--------------------------------------------");

				Thread.sleep(1000);
			}

		} catch (SQLException e) {
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("Hubo un error al actualizar el usuario con la CI " + ci + ", intente nuevamente");
			System.out.println("--------------------------------------------------------------------------------");

			Thread.sleep(1000);
		}
	}

	public void showUsuario(int ci) throws InterruptedException {
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT ci, nombre, apellido FROM Usuario WHERE ci = " + ci + ";";
			rs = stmt.executeQuery(query);

			if (rs.next() == true) {
				do {
					System.out.println("\n> CI: " + rs.getString("ci") 
						+ "\n\n> Nombre: " + rs.getString("nombre") 
						+ "\n\n> Apellido: " + rs.getString("apellido")
					);
				} while (rs.next());

				Thread.sleep(1000);
			} else {
				System.out.println("--------------------------------------------");
				System.out.println("El usuario con la CI " + ci + " no existe");
				System.out.println("--------------------------------------------");
				Thread.sleep(1000);
			}

		} catch (SQLException e) {
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("Hubo un error al mostrar el usuario con la CI " + ci + ", intente nuevamente");
			System.out.println("--------------------------------------------------------------------------------");
			
			Thread.sleep(1000);
		}
	}

	public void createEstudiante(int ci) throws InterruptedException {
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT ci FROM Usuario WHERE ci = " + ci + ";";
			rs = stmt.executeQuery(query);

			if (rs.next() == true) {

				String query2 = "SELECT ci FROM Estudiante WHERE ci = " + ci + ";";
				rs = stmt.executeQuery(query2);

				if (rs.next() == false) {
					String insert = "INSERT INTO Estudiante VALUES(" + ci + ", null);";
					stmt.executeUpdate(insert);

					System.out.println("--------------------------------------------");
					System.out.println("Se agrego el estudiante correctamente");
					System.out.println("--------------------------------------------");

					Thread.sleep(1000);
				} else {
					System.out.println("--------------------------------------------");
					System.out.println("El estudiante con la CI " + ci + " ya existe");
					System.out.println("--------------------------------------------");

					Thread.sleep(1000);
				}
			} else {
				System.out.println("------------------------------------------------------------");
				System.out.println("No hay un usuario con la CI " + ci + ", debe de crear uno");
				System.out.println("------------------------------------------------------------");
				
				Thread.sleep(1000);
			}
		} catch (SQLException e) {
			System.out.println("----------------------------------------------------------------------------------");
			System.out.println("Hubo un error al agregar el estudiante con la CI " + ci + ", intente nuevamente");
			System.out.println("----------------------------------------------------------------------------------");

			Thread.sleep(1000);
		}
	}

	public void deleteEstudiante(int ci) throws InterruptedException {
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT ci FROM Estudiante WHERE ci = " + ci + ";";
			rs = stmt.executeQuery(query);

			if (rs.next() != false) {
				String insert = "DELETE FROM Estudiante WHERE ci = " + ci + ";";
				stmt.executeUpdate(insert);

				System.out.println("------------------------------------------------------------");
				System.out.println("Se borro el estudiante con la CI " + ci + " correctamente");
				System.out.println("------------------------------------------------------------");

				Thread.sleep(1000);
			} else {
				System.out.println("-------------------------------------------------");
				System.out.println("El estudiante con la CI " + ci + " no existe");
				System.out.println("-------------------------------------------------");

				Thread.sleep(1000);
			}

		} catch (SQLException e) {
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("Hubo un error al borrar el estudiante con la CI " + ci + ", intente nuevamente");
			System.out.println("--------------------------------------------------------------------------------");

			Thread.sleep(1000);
		}
	}

	public void showEstudiante(int ci) throws InterruptedException {
		try {
			Statement stmt = con.createStatement();

			String showUser = "SELECT Usuario.ci, Usuario.nombre, Usuario.apellido, Estudiante.nroEstudiante FROM Usuario JOIN Estudiante ON Usuario.ci = Estudiante.ci WHERE Estudiante.ci = " + ci + ";";
			rs = stmt.executeQuery(showUser);

			if (rs.next() == true) {
				do {
					System.out.println("\n> CI: " + rs.getString("Usuario.ci") 
						+ "\n\n> Numero de estudiante: " + rs.getString("Estudiante.nroEstudiante") 
						+ "\n\n> Nombre: " + rs.getString("Usuario.nombre")
						+ "\n\n> Apellido: " + rs.getString("Usuario.apellido")
					);
				} while (rs.next());

				Thread.sleep(1000);
			} else {
				System.out.println("------------------------------------------------");
				System.out.println("El estudiante con la CI " + ci + " no existe");
				System.out.println("------------------------------------------------");

				Thread.sleep(1000);
			}

		} catch (SQLException e) {
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("Hubo un error al mostrar el estudiante con la CI " + ci + ", intente nuevamente");
			System.out.println("--------------------------------------------------------------------------------");

			Thread.sleep(1000);
		}
	}

	public void createProfesor(int ci) throws InterruptedException {
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT ci FROM Usuario WHERE ci = " + ci + ";";
			rs = stmt.executeQuery(query);

			if (rs.next() == true) {

				String query2 = "SELECT ci FROM Profesor WHERE ci = " + ci + ";";
				rs = stmt.executeQuery(query2);

				if (rs.next() == false) {
					String insert = "INSERT INTO Profesor VALUES(" + ci + ", null);";
					stmt.executeUpdate(insert);

					System.out.println("--------------------------------------------------------------");
					System.out.println("Se agrego el profesor con la CI " + ci + " correctamente");
					System.out.println("--------------------------------------------------------------");

					Thread.sleep(1000);
				} else {
					System.out.println("-----------------------------------------------");
					System.out.println("El profesor con la CI " + ci + " ya existe");
					System.out.println("-----------------------------------------------");

					Thread.sleep(1000);
				}
			} else {
				System.out.println("----------------------------------------------------------------");
				System.out.println("No hay un usuario con la CI " + ci + ", debe de crear uno");
				System.out.println("----------------------------------------------------------------");

				Thread.sleep(1000);
			}
		} catch (SQLException e) {
			System.out.println("---------------------------------------------------------------------------------");
			System.out.println("Hubo un error al agregar el profesor con la CI " + ci + ", intente nuevamente");
			System.out.println("---------------------------------------------------------------------------------");

			Thread.sleep(1000);
		}
	}

	public void deleteProfesor(int ci) throws InterruptedException {
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT ci FROM Profesor WHERE ci = " + ci + ";";
			rs = stmt.executeQuery(query);

			if (rs.next() != false) {
				String insert = "DELETE FROM Profesor WHERE ci = " + ci + ";";
				stmt.executeUpdate(insert);

				System.out.println("-----------------------------------------------------------");
				System.out.println("Se borro el profesor con la CI " + ci + " correctamente");
				System.out.println("-----------------------------------------------------------");

				Thread.sleep(1000);
			} else {
				System.out.println("-------------------------------------------------");
				System.out.println("El profesor con la CI " + ci + " no existe");
				System.out.println("-------------------------------------------------");

				Thread.sleep(1000);
			}

		} catch (SQLException e) {
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println("Hubo un error al borrar el profesor con la CI " + ci + ", intente nuevamente");
			System.out.println("-----------------------------------------------------------------------------------");

			Thread.sleep(1000);
		}
	}

	public void showProfesor(int ci) throws InterruptedException {
		try {
			Statement stmt = con.createStatement();
			String showUser = "SELECT Usuario.ci, Usuario.nombre, Usuario.apellido, Profesor.matricula FROM Usuario JOIN Profesor ON Usuario.ci = Profesor.ci WHERE Profesor.ci = " + ci + ";";
			rs = stmt.executeQuery(showUser);

			if (rs.next() == true) {
				do {
					System.out.println("\n> Ci: " + rs.getString("Usuario.ci") 
						+ "\n\n> Matricula: " + rs.getString("Profesor.matricula")
						+ "\n\n> Nombre: " + rs.getString("Usuario.nombre") 
						+ "\n\n> Apellido: " + rs.getString("Usuario.apellido")
					);
				} while (rs.next());

				Thread.sleep(1000);
			} else {
				System.out.println("-----------------------------------------------");
				System.out.println("El profesor con la CI " + ci + " no existe");
				System.out.println("-----------------------------------------------");

				Thread.sleep(1000);
			}

		} catch (SQLException e) {			
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("Hubo un error al mostrar el profesor con la CI " + ci + ", intente nuevamente");
			System.out.println("-------------------------------------------------------------------------------");

			Thread.sleep(1000);
		}
	}

	public void createMateria(Materia materia) throws InterruptedException {
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT nombre FROM Materia WHERE nombre = '" + materia.getNombre() + "';";
			rs = stmt.executeQuery(query);

			if (rs.next() == false) {
				String insert = "INSERT INTO Materia VALUES(null, '" + materia.getNombre() + "');";
				stmt.executeUpdate(insert);

				System.out.println("----------------------------------------------------------------");
				System.out.println("Se agrego la materia " + materia.getNombre() + " con exito");
				System.out.println("----------------------------------------------------------------");

				Thread.sleep(1000);
			} else {
				System.out.println("-----------------------------------------------------");
				System.out.println("La materia " + materia.getNombre() + " ya existe");
				System.out.println("-----------------------------------------------------");

				Thread.sleep(1000);
			}

		} catch (SQLException e) {
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("Hubo un erro al crear la materia " + materia.getNombre() + ", intente denuevo");
			System.out.println("-------------------------------------------------------------------------------");

			Thread.sleep(1000);
		}
	}

	public void deleteMateria(String nombre) throws InterruptedException {
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT nombre FROM Materia WHERE nombre = '" + nombre + "';";
			rs = stmt.executeQuery(query);

			if (rs.next() != false) {
				String insert = "DELETE FROM Materia WHERE nombre = '" + nombre + "';";
				stmt.executeUpdate(insert);

				System.out.println("-------------------------------------------------------");
				System.out.println("Se borro la materia " + nombre + " correctamente");
				System.out.println("-------------------------------------------------------");

				Thread.sleep(1000);
			} else {
				System.out.println("--------------------------------------------");
				System.out.println("La materia " + nombre + " no existe");
				System.out.println("--------------------------------------------");

				Thread.sleep(1000);
			}

		} catch (SQLException e) {
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("Hubo un error al borrar la materia " + nombre + ", intente nuevamente");
			System.out.println("-----------------------------------------------------------------------");

			Thread.sleep(1000);
		}
	}

	public void updateMateria(int codigo, String nombre) throws InterruptedException {
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT codigo, nombre FROM Materia WHERE codigo = " + codigo + ";";
			rs = stmt.executeQuery(query);

			if (rs.next() != false) {
				String insert = "UPDATE Materia SET nombre = '" + nombre + "' WHERE codigo = " + codigo + ";";
				stmt.executeUpdate(insert);

				System.out.println("----------------------------------------------------------------------------------");
				System.out.println("Se actualizaron los datos de la materia con el codigo " + codigo + " correctamente");
				System.out.println("----------------------------------------------------------------------------------");

				Thread.sleep(1000);

			} else {
				System.out.println("-----------------------------------------------------");
				System.out.println("La materia con el codigo " + codigo + " no existe");
				System.out.println("-----------------------------------------------------");

				Thread.sleep(1000);
			}

		} catch (SQLException e) {
			System.out.println("------------------------------------------------------------------------------------------");
			System.out.println("Hubo un error al actualizar la materia con el codigo " + codigo + ", intente nuevamente");
			System.out.println("------------------------------------------------------------------------------------------");

			Thread.sleep(1000);
		}
	}

	public void showMateria(String nombre) throws InterruptedException {
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT codigo, nombre FROM Materia WHERE nombre = '" + nombre + "';";
			rs = stmt.executeQuery(query);

			if (rs.next() == true) {
				do {
					System.out.println("\n> Codigo: " + rs.getString("codigo") + "\n\n> Nombre: " + rs.getString("nombre"));

				} while (rs.next());
				Thread.sleep(1000);

			} else {
				System.out.println("--------------------------------------------");
				System.out.println("La materia " + nombre + " no existe");
				System.out.println("--------------------------------------------");
				
				Thread.sleep(1000);
			}

		} catch (SQLException e) {
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("Hubo un error al mostrar la materia " + nombre + ", intente nuevamente");
			System.out.println("---------------------------------------------------------------------------");
			
			Thread.sleep(1000);
		}
	}

	public void addMateriaProfe(int ci, String nombreMateria) throws InterruptedException {
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT ci, matricula FROM Profesor WHERE ci = " + ci + ";";
			rs = stmt.executeQuery(query);

			if (rs.next() == true) {
				int matricula = rs.getInt("matricula");

				String query2 = "SELECT codigo, nombre FROM Materia WHERE nombre = '" + nombreMateria + "';";
				rs = stmt.executeQuery(query2);

				if (rs.next() == true) {
					int codigoMateria = rs.getInt("codigo");

					String query3 = "SELECT matricula, codigoMateria FROM Dicta WHERE matricula = " + matricula + " AND codigoMateria = " + codigoMateria + ";";
					rs = stmt.executeQuery(query3);

					if (rs.next() == false) {
						String insert = "INSERT INTO Dicta VALUES(" + matricula + ", " + codigoMateria + ");";
						stmt.executeUpdate(insert);

						System.out.println("----------------------------------------------------------------------------------------");	
						System.out.println("Se agrego la materia " + nombreMateria + " al profesor con la CI " + ci + " con exito");
						System.out.println("----------------------------------------------------------------------------------------");	

						Thread.sleep(1000);
					} else {
						System.out.println("-------------------------------------------------------------------------------");
						System.out.println("La materia " + nombreMateria + " ya esta asignada al profesor con la CI" + ci);
						System.out.println("-------------------------------------------------------------------------------");

						Thread.sleep(1000);
					}
				} else {
					System.out.println("------------------------------------------------");					
					System.out.println("La materia " + nombreMateria + " no existe");
					System.out.println("------------------------------------------------");					

					Thread.sleep(1000);
				}
			} else {
				System.out.println("------------------------------------------------");					
				System.out.println("El profesor con la CI " + ci + " no existe");
				System.out.println("------------------------------------------------");					

				Thread.sleep(1000);
			}

		} catch (SQLException e) {
			System.out.println("------------------------------------------------------------------------------------------------------------------");	
			System.out.println("Hubo un error al agregarle la materia " + nombreMateria + " al profesor con la CI " + ci + ", intente denuevo");
			System.out.println("------------------------------------------------------------------------------------------------------------------");	
			
			Thread.sleep(1000);
		}
	}

	public void deleteMateriaProfe(int ci, String nombreMateria) throws InterruptedException {
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT ci, matricula FROM Profesor WHERE ci = " + ci + ";";
			rs = stmt.executeQuery(query);

			if (rs.next() == true) {
				int matricula = rs.getInt("matricula");

				String query2 = "SELECT codigo, nombre FROM Materia WHERE nombre = '" + nombreMateria + "';";
				rs = stmt.executeQuery(query2);

				if (rs.next() == true) {
					int codigoMateria = rs.getInt("codigo");

					String query3 = "SELECT matricula, codigoMateria FROM Dicta WHERE matricula = " + matricula + " AND codigoMateria = " + codigoMateria + ";";
					rs = stmt.executeQuery(query3);

					if(rs.next() == true){
						String insert = "DELETE FROM Dicta WHERE matricula = " + matricula + " AND codigoMateria = " + codigoMateria + ";";
						stmt.executeUpdate(insert);
	
						System.out.println("------------------------------------------------------------------------------------------");					
						System.out.println("Se borro la materia " + nombreMateria + " del profesor con la CI " + ci + " correctamente");
						System.out.println("------------------------------------------------------------------------------------------");					
	
						Thread.sleep(1000);
					}else{
						System.out.println("---------------------------------------------------------------------------------------");	
						System.out.println("El profesor con la CI " + ci + " no tiene la materia " + nombreMateria + " asignada");
						System.out.println("---------------------------------------------------------------------------------------");	
						
						Thread.sleep(1000);
					}
				} else {
					System.out.println("-----------------------------------------------");	
					System.out.println("La materia " + nombreMateria + " no existe");
					System.out.println("-----------------------------------------------");	

					Thread.sleep(1000);
				}
			} else {
				System.out.println("-----------------------------------------------");	
				System.out.println("El profesor con la CI " + ci + " no existe");
				System.out.println("-----------------------------------------------");

				Thread.sleep(1000);
			}

		} catch (SQLException e) {
			System.out.println("--------------------------------------------------------------------------------------------------------------------");	
			System.out.println("Hubo un error al borrar la materia " + nombreMateria + " del profesor con la CI " + ci + ", intente nuevamente");
			System.out.println("--------------------------------------------------------------------------------------------------------------------");	

			Thread.sleep(1000);
		}
	}

	public void showMateriaProfe(int ci) throws InterruptedException {
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT ci, matricula FROM Profesor WHERE ci = " + ci + ";";
			rs = stmt.executeQuery(query);

			if (rs.next() == true) {
				int matricula = rs.getInt("matricula");

				String query2 = "SELECT nombre FROM Materia JOIN Dicta ON Materia.codigo = Dicta.codigoMateria WHERE Dicta.matricula = " + matricula + ";";
				rs = stmt.executeQuery(query2);

				if (rs.next() == true) {
					do {
						System.out.println("\n> Materia: " + rs.getString("nombre"));
					} while (rs.next());

					Thread.sleep(1000);
				} else {
					System.out.println("---------------------------------------------------------------");	
					System.out.println("El profesor con la CI " + ci + " no tiene materias asignadas");
					System.out.println("---------------------------------------------------------------");
					
					Thread.sleep(1000);
				}

			} else {
				System.out.println("------------------------------------------------");	
				System.out.println("El profesor con la CI " + ci + " no existe");
				System.out.println("------------------------------------------------");	

				Thread.sleep(1000);
			}

		} catch (SQLException e) {
			System.out.println("------------------------------------------------------------------------------------------------");	
			System.out.println("Hubo un error al mostrar las materias del profesor con la CI " + ci + ", intente denuevo");
			System.out.println("------------------------------------------------------------------------------------------------");	
			
			Thread.sleep(1000);
		}
	}

	public void addMateriaEstu(int ci, String nombreMateria) throws InterruptedException {
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT ci, nroEstudiante FROM Estudiante WHERE ci = " + ci + ";";
			rs = stmt.executeQuery(query);

			if (rs.next() == true) {
				int nroEstudiante = rs.getInt("nroEstudiante");

				String query2 = "SELECT codigo, nombre FROM Materia WHERE nombre = '" + nombreMateria + "';";
				rs = stmt.executeQuery(query2);

				if (rs.next() == true) {
					int codigoMateria = rs.getInt("codigo");

					String query3 = "SELECT nroEstudiante, codigoMateria FROM Tiene WHERE nroEstudiante = " + nroEstudiante + " AND codigoMateria = " + codigoMateria + ";";
					rs = stmt.executeQuery(query3);

					if (rs.next() == false) {

						String insert = "INSERT INTO Tiene VALUES(" + nroEstudiante + ", " + codigoMateria + ");";
						stmt.executeUpdate(insert);

						System.out.println("----------------------------------------------------------------------------------------------");		
						System.out.println("Se agrego la materia " + nombreMateria + " al estudiante con la CI " + ci + " con exito");
						System.out.println("----------------------------------------------------------------------------------------------");		

						Thread.sleep(1000);
					} else {
						System.out.println("---------------------------------------------------------------------------------");		
						System.out.println("La materia " + nombreMateria + " ya existe en el estudiante con la CI " + ci);
						System.out.println("---------------------------------------------------------------------------------");		

						Thread.sleep(1000);
					}
				} else {
					System.out.println("------------------------------------------------");	
					System.out.println("La materia " + nombreMateria + " no existe");
					System.out.println("------------------------------------------------");	

					Thread.sleep(1000);
				}
			} else {
				System.out.println("------------------------------------------------");	
				System.out.println("El estudiante con la CI " + ci + " no existe");
				System.out.println("------------------------------------------------");	

				Thread.sleep(1000);
			}

		} catch (SQLException e) {
			System.out.println("------------------------------------------------------------------------------------------------------------------");	
			System.out.println("Hubo un error al agregarle la materia " + nombreMateria + " al estudiante con la CI " + ci + ", intente denuevo");
			System.out.println("------------------------------------------------------------------------------------------------------------------");	
			
			Thread.sleep(1000);
		}
	}

	public void deleteMateriaEstu(int ci, String nombreMateria) throws InterruptedException {
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT ci, nroEstudiante FROM Estudiante WHERE ci = " + ci + ";";
			rs = stmt.executeQuery(query);

			if (rs.next() == true) {
				int nroEstudiante = rs.getInt("nroEstudiante");

				String query2 = "SELECT codigo, nombre FROM Materia WHERE nombre = '" + nombreMateria + "';";
				rs = stmt.executeQuery(query2);

				if (rs.next() == true) {
					int codigoMateria = rs.getInt("codigo");

					String insert = "DELETE FROM Tiene WHERE nroEstudiante = " + nroEstudiante + " AND codigoMateria = " + codigoMateria + ";";
					stmt.executeUpdate(insert);

					System.out.println("----------------------------------------------------------------------------------------------");	
					System.out.println("Se borro la materia " + nombreMateria + " del estudiante con la CI " + ci + " correctamente");
					System.out.println("----------------------------------------------------------------------------------------------");	

					Thread.sleep(1000);
				} else {
					System.out.println("------------------------------------------------");	
					System.out.println("La materia " + nombreMateria + " no existe");
					System.out.println("------------------------------------------------");	
					
					Thread.sleep(1000);
				}
			} else {
				System.out.println("------------------------------------------------");	
				System.out.println("El estudiante con la CI " + ci + " no existe");
				System.out.println("------------------------------------------------");	
			}

		} catch (SQLException e) {
			System.out.println("-------------------------------------------------------------------------------------------------------------------");	
			System.out.println("Hubo un error al borrar la materia " + nombreMateria + " del estudiante con la CI " + ci + ", intente nuevamente");
			System.out.println("-------------------------------------------------------------------------------------------------------------------");	

			Thread.sleep(1000);
		}
	}

	public void showMateriaEstu(int ci) throws InterruptedException {
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT ci, nroEstudiante FROM Estudiante WHERE ci = " + ci + ";";
			rs = stmt.executeQuery(query);

			if (rs.next() == true) {
				int nroEstudiante = rs.getInt("nroEstudiante");

				String query2 = "SELECT nombre FROM Materia JOIN Tiene ON Materia.codigo = Tiene.codigoMateria WHERE Tiene.nroEstudiante = " + nroEstudiante + ";";
				rs = stmt.executeQuery(query2);

				if (rs.next() == true) {
					do {
						System.out.println("\n> Materia: " + rs.getString("nombre") + "\n");
					} while (rs.next());

					Thread.sleep(1000);
				} else {
					System.out.println("---------------------------------------------------------------------");	
					System.out.println("El estudiante con la CI " + ci + " no tiene materias asignadas");
					System.out.println("---------------------------------------------------------------------");	
				}
			} else {
				System.out.println("---------------------------------------------------");	
				System.out.println("El estudiante con la CI " + ci + ", no existe");
				System.out.println("---------------------------------------------------");

				Thread.sleep(1000);
			}

		} catch (SQLException e) {
			System.out.println("----------------------------------------------------------------------------------------------");	
			System.out.println("Hubo un error al mostrar las materias del estudiante con la CI " + ci + ", intente denuevo");
			System.out.println("----------------------------------------------------------------------------------------------");	
	
			Thread.sleep(1000);
		}
	}
}