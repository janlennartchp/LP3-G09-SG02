import java.util.*;

public class Main {
    public static void main(String[] args) {
        GestorRegistros gestor = new GestorRegistros();

        gestor.limpiarTabla();

        gestor.agregarEmpleado(new Empleado(1, "Ana", 25, 1500));
        gestor.agregarEmpleado(new Empleado(2, "Luis", 30, 1200));
        gestor.agregarEmpleado(new Empleado(3, "María", 22, 1800));
        gestor.agregarEmpleado(new Empleado(4, "Juan", 35, 1100));

        Scanner sc = new Scanner(System.in);

        System.out.println("¿Qué campos deseas mostrar? (Ejemplo: nombre,edad,sueldo)");
        List<String> campos = Arrays.asList(sc.nextLine().split(","));

        System.out.println("¿Deseas aplicar una condición? (Ejemplo: sueldo>1200) o deja vacío:");
        String condicion = sc.nextLine();

        System.out.println("¿Campo para ordenar? (Ejemplo: edad, sueldo o vacío):");
        String ordenarPor = sc.nextLine();

        System.out.println("¿Orden ascendente? (true/false):");
        boolean asc = Boolean.parseBoolean(sc.nextLine());

        System.out.println("¿Límite de registros (0 = sin límite)?:");
        int limite = Integer.parseInt(sc.nextLine());

        System.out.println("\n--- RESULTADOS ---");
        gestor.consultar(campos, condicion, ordenarPor, asc, limite);

        gestor.cerrarConexion();
        sc.close();
    }
}
