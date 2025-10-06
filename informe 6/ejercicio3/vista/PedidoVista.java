package vista;

import modelo.Pedido;
import java.util.List;
import java.util.Scanner;
public class PedidoVista {
    private Scanner scanner;
    public PedidoVista() {
        scanner = new Scanner(System.in);
    }
    public String solicitarNombrePlato() {
        System.out.print("Introduce el nombre del plato: ");
        return scanner.nextLine();
    }
    public String solicitarTipoPlato() {
        System.out.print("Introduce el tipo del plato (Entrada, Fondo, Postre, Bebida): ");
        return scanner.nextLine();
    }
    public void mostrarPedidos(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos para mostrar.");
        } else {
            System.out.println("\nLista de Pedidos:");
            for (Pedido p : pedidos) {
                System.out.println("- " + p);
            }
        }
    }
    public void mostrarMenu() {
        System.out.println("\n=== MENÚ ===");
        System.out.println("1. Agregar Pedido");
        System.out.println("2. Mostrar Pedidos Pendientes");
        System.out.println("3. Marcar Pedido como Completo");
        System.out.println("4. Mostrar Pedidos Completos");
        System.out.println("5. Eliminar Pedido");
        System.out.println("6. Mostrar Historial de Pedidos");
        System.out.println("7. Contar Pedidos Pendientes");
        System.out.println("8. Salir");
    }
    public String solicitarOpcion() {
        System.out.print("Selecciona una opción: ");
        return scanner.nextLine();
    }
    public String solicitarTexto(String mensaje) {
        System.out.print(mensaje + ": ");
        return scanner.nextLine();
    }
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    public void cerrarScanner() {
        scanner.close();
    }
}
