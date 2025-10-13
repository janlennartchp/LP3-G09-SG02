import java.io.*;
import java.util.*;

public class EmpleadoModelo {
    private final String archivo = "empleados.txt";
    private List<Empleado> empleados;

    public EmpleadoModelo() {
        empleados = new ArrayList<>();
        leerEmpleados();
    }

    public void leerEmpleados() {
        empleados.clear();
        File file = new File(archivo);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Empleado e = Empleado.fromString(linea);
                if (e != null) empleados.add(e);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void guardarEmpleados() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Empleado e : empleados) {
                bw.write(e.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar empleados: " + e.getMessage());
        }
    }

    public void listarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }
        System.out.println("\nLista de empleados:");
        for (Empleado e : empleados) {
            System.out.println("Número: " + e.getNumero() +
                               " | Nombre: " + e.getNombre() +
                               " | Sueldo: " + e.getSueldo());
        }
    }

    public void agregarEmpleado(Empleado e) {
        empleados.add(e);
        guardarEmpleados();
        System.out.println("Empleado agregado correctamente.");
    }

    public Empleado buscarEmpleado(int numero) {
        for (Empleado e : empleados) {
            if (e.getNumero() == numero) return e;
        }
        return null;
    }

    public void eliminarEmpleado(int numero) {
        empleados.removeIf(e -> e.getNumero() == numero);
        guardarEmpleados();
        System.out.println("Empleado eliminado correctamente (si existía).");
    }
}

