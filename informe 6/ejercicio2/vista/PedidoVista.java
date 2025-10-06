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
            System.out.println("No hay pedidos en la lista.");
        } else {
            System.out.println("\nLista de Pedidos:");
            for (Pedido pedido : pedidos) {
                System.out.println("- " + pedido);
            }
        }
    }
    public void mostrarMenu() {
        System.out.println("\n=== MENÚ ===");
        System.out.println("1. Agregar Pedido");
        System.out.println("2. Mostrar Pedidos");
        System.out.println("3. Eliminar Pedido");
        System.out.println("4. Actualizar Pedido");
        System.out.println("5. Buscar Pedido por nombre o tipo");
        System.out.println("6. Contar Pedidos");
        System.out.println("7. Salir");
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
