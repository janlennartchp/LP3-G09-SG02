package controlador;

import modelo.Item;
import modelo.InventarioModel;
import vista.InventarioView;
import java.util.List;
public class InventarioController {
    private InventarioModel modelo;
    private InventarioView vista;
    public InventarioController(InventarioModel modelo, InventarioView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    public void agregarItem() {
        String nombre = vista.solicitarTexto("Nombre del ítem");
        int cantidad = vista.solicitarNumero("Cantidad");
        String tipo = vista.solicitarTexto("Tipo (Arma, Poción, etc.)");
        String descripcion = vista.solicitarTexto("Descripción");
        Item nuevo = new Item(nombre, cantidad, tipo, descripcion);
        modelo.agregarItem(nuevo);
        vista.mostrarMensaje(" Ítem agregado correctamente.");
    }
    public void eliminarItem() {
        String nombre = vista.solicitarTexto("Nombre del ítem a eliminar");
        Item item = modelo.buscarItem(nombre);
        if (item != null) {
            modelo.eliminarItem(item);
            vista.mostrarMensaje(" Ítem eliminado del inventario.");
        } else {
            vista.mostrarMensaje(" Ítem no encontrado.");
        }
    }
    public void verInventario() {
        List<Item> items = modelo.obtenerItems();
        vista.mostrarInventario(items);
    }
    public void mostrarDetalles() {
        String nombre = vista.solicitarTexto("Nombre del ítem a consultar");
        Item item = modelo.buscarItem(nombre);
        vista.mostrarDetallesItem(item);
    }
    public void buscarItem() {
        String nombre = vista.solicitarTexto("Nombre del ítem a buscar");
        Item item = modelo.buscarItem(nombre);
        if (item != null) {
            vista.mostrarMensaje(" Ítem encontrado: " + item);
        } else {
            vista.mostrarMensaje(" No se encontró ningún ítem con ese nombre.");
        }
    }
    public void iniciar() {
        String opcion;
        do {
            System.out.println("\n=== MENÚ DEL INVENTARIO ===");
            System.out.println("1. Agregar ítem");
            System.out.println("2. Eliminar ítem");
            System.out.println("3. Ver inventario");
            System.out.println("4. Mostrar detalles de un ítem");
            System.out.println("5. Buscar ítem");
            System.out.println("6. Salir");
            opcion = vista.solicitarTexto("Seleccione una opción");
            switch (opcion) {
                case "1": agregarItem(); break;
                case "2": eliminarItem(); break;
                case "3": verInventario(); break;
                case "4": mostrarDetalles(); break;
                case "5": buscarItem(); break;
                case "6": vista.mostrarMensaje(" Saliendo del sistema..."); break;
                default: vista.mostrarMensaje(" Opción no válida. Intente nuevamente.");
            }
        } while (!opcion.equals("6"));
        vista.cerrarScanner();
    }
}
