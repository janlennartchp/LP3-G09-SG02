package vista;

import modelo.Producto;
import java.util.List;
import java.util.Scanner;
public class TiendaVista {
    private Scanner scanner = new Scanner(System.in);
    public void mostrarMenu() {
        System.out.println("\n=== MENÚ DE LA TIENDA ===");
        System.out.println("1. Agregar Producto al Catálogo");
        System.out.println("2. Listar Productos Disponibles");
        System.out.println("3. Agregar Producto al Carrito");
        System.out.println("4. Ver Carrito");
        System.out.println("5. Eliminar Producto del Carrito");
        System.out.println("6. Aplicar Descuento");
        System.out.println("7. Calcular Envío");
        System.out.println("8. Realizar Compra");
        System.out.println("9. Ver Historial de Compras");
        System.out.println("10. Salir");
    }
    public String solicitarTexto(String mensaje) {
        System.out.print(mensaje + ": ");
        return scanner.nextLine();
    }
    public double solicitarNumero(String mensaje) {
        System.out.print(mensaje + ": ");
        while (!scanner.hasNextDouble()) {
            System.out.print("Por favor, ingrese un número válido: ");
            scanner.next();
        }
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;
    }
    public void mostrarProductos(List<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            System.out.println("\nProductos:");
            for (Producto p : productos) {
                System.out.println("- " + p);
            }
        }
    }
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    public void cerrarScanner() {
        scanner.close();
    }
}
