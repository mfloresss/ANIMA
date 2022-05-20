import java.util.ArrayList;
import java.util.Scanner;

public class App {
	public static void main(String[] args) throws Exception {
		Scanner tec = new Scanner(System.in);
		char opc;

		ArrayList<Persona> personas = new ArrayList<Persona>();
		ArrayList<Auto> autos = new ArrayList<Auto>();

		do {
			System.out.println("1 - Ingresar auto" + "\n2 - Retirar auto" + "\n3 - Cerrar programa");
			opc = tec.nextLine().charAt(0);

			switch (opc) {
				case '1':
					
					String nombre = tec.nextLine();
					personas.add(new Persona(nombre));

					for (int i = 0; i < personas.size(); i++) {
						if (personas.get(i).getNombre().toLowerCase().equals(nombre)) {
							currentPersona = personas.get(i);
						}
					}

					String matricula = tec.nextLine();
					autos.add(new Auto(Auto.AUDI, matricula, currentPersona));

					// Estacionamiento.entra(auto);
					break;
				case '2':
					String autoRetirar = tec.nextLine();

					// Estacionamiento.sale(auto);
					break;
				case '0':
					break;
				default:
					break;
			}
		} while (opc != '0');

		Estacionamiento.inicializar(2, 60, 180);
		// se inicializa el estacionamiento con 2 lugares,
		// $60 para el ingreso, $180 la noche

		Persona juan = new Persona("Juan");
		Auto autoJuan = new Auto(Auto.MERCEDEZ_BENZ, "BCF-235", juan);

		Estacionamiento.entra(autoJuan);
		// se inicializa la cuenta corriente a Juan y se le agrega $60

		Persona ana = new Persona("Ana");
		Auto autoAna = new Auto(Auto.FIAT, "BRF-535", ana);
		Estacionamiento.entra(autoAna);

		Estacionamiento.sale(autoJuan);

		Estacionamiento.nuevoDia();
		// cierra el estacionamiento y abre el dia siguiente

		Estacionamiento.entra(autoJuan);
		Persona felipe = new Persona("Felipe");
		Auto autoFelipe = new Auto(Auto.PEUGEOT, "BFD-124", felipe);
		Estacionamiento.entra(autoFelipe);
		// notar que no entra el auto, asi que no tiene ningun efecto

		Estacionamiento.calcular();
	}
}
