package vista;

import modelo.Item;
import java.util.List;
import java.util.Scanner;

public class InventarioView {
    private Scanner scanner;

    public InventarioView() {
        scanner = new Scanner(System.in);
    }

    public void mostrarInventario(List<Item> items) {
        if (items.isEmpty()) {
            System.out.println("📦 No hay ítems en el inventario.");
        } else {
            System.out.println("\n=== INVENTARIO ===");
            for (Item item : items) {
                System.out.println("- " + item);
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String solicitarTexto(String mensaje) {
        System.out.print(mensaje + ": ");
        return scanner.nextLine();
    }

    public int solicitarNumero(String mensaje) {
        System.out.print(mensaje + ": ");
        while (!scanner.hasNextInt()) {
            System.out.print("Ingrese un número válido: ");
            scanner.next();
        }
        int num = scanner.nextInt();
        scanner.nextLine();
        return num;
    }

    public void cerrarScanner() {
        scanner.close();
    }
}
