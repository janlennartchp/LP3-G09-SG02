package controlador;

import modelo.*;
import vista.InventarioView;
import java.util.List;

public class InventarioController {
    private InventarioModel modelo;
    private InventarioView vista;

    public InventarioController(InventarioModel modelo, InventarioView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void verInventario() {
        List<Item> items = modelo.obtenerItems();
        vista.mostrarInventario(items);
    }

    public void agregarItem() {
        String nombre = vista.solicitarTexto("Nombre del ítem");
        int cantidad = vista.solicitarNumero("Cantidad");
        String tipo = vista.solicitarTexto("Tipo (Arma, Poción, etc.)");
        String descripcion = vista.solicitarTexto("Descripción");
        modelo.agregarItem(new Item(nombre, cantidad, tipo, descripcion));
        vista.mostrarMensaje("✅ Ítem agregado correctamente.");
    }

    public void eliminarItem() {
        String nombre = vista.solicitarTexto("Nombre del ítem a eliminar");
        Item item = modelo.buscarItem(nombre);
        if (item != null) {
            modelo.eliminarItem(item);
            vista.mostrarMensaje("🗑️ Ítem eliminado.");
        } else {
            vista.mostrarMensaje("❌ Ítem no encontrado.");
        }
    }
}
