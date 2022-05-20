import java.util.ArrayList;

public class Estacionamiento {
    private final static int MAX_LUGARES = 8;
    private static int lugares;
    private static int precioIngreso;
    private static int precioNoche;

    private static ArrayList<Persona> lugaresOcupados = new ArrayList<Persona>();

    public static void inicializar(int lugares, int precioIngreso, int precioNoche) {
        Estacionamiento.lugares = lugares;
        Estacionamiento.precioIngreso = precioIngreso;
        Estacionamiento.precioNoche = precioNoche;
        Estacionamiento.lugaresOcupados = new ArrayList<Persona>();
    }

    public static void entra(Auto auto) {
        if (Estacionamiento.lugares > 0 && Estacionamiento.lugares < MAX_LUGARES) {
            int numRandom = (int) (Math.random() * 123890) + 1;

            Estacionamiento.lugares--;

            lugaresOcupados.add(auto.getPersona());

            auto.getPersona().setCuenta(Integer.toString(numRandom));

            System.out.println(
                    "========================================\n" +
                            "Nombre: " + auto.getPersona().getNombre() +
                            "\nNro de cuenta: " + auto.getPersona().getCuenta() +
                            "\nAuto: " + auto.getMarca() +
                            "\n========================================");
        } else {
            System.out.println("No se pueden ingresar mas autos");
        }
    }

    public static void sale(Auto auto) {
        // TODO: verificar si relamente esta el auto en el estacionamiento
        Estacionamiento.lugares++;
        lugaresOcupados.remove(auto.getPersona());
        System.out.println("Sale " + auto.getMatricula());
    }

    public static void calcular() {

    }

    public static void nuevoDia() {

        // Hcer suma de precio noche

    }
}
