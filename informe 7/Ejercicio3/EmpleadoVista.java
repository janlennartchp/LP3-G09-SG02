import java.util.Scanner;

public class EmpleadoVista {
    private Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n=== MENÚ DE EMPLEADOS ===");
        System.out.println("1. Listar todos los empleados");
        System.out.println("2. Agregar un nuevo empleado");
        System.out.println("3. Buscar empleado por número");
        System.out.println("4. Eliminar empleado por número");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
        return sc.nextInt();
    }

    public int solicitarNumero() {
        System.out.print("Ingrese el número del empleado: ");
        return sc.nextInt();
    }

    public String solicitarNombre() {
        System.out.print("Ingrese el nombre del empleado: ");
        sc.nextLine(); // limpiar buffer
        return sc.nextLine();
    }

    public double solicitarSueldo() {
        System.out.print("Ingrese el sueldo del empleado: ");
        return sc.nextDouble();
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }
}
