package controlador;

import modelo.*;
import vista.TiendaVista;
import java.util.ArrayList;
import java.util.List;
public class TiendaControlador {
    private List<Producto> catalogo;
    private Carrito carrito;
    private CompraHistorial historial;
    private TiendaVista vista;
    public TiendaControlador(TiendaVista vista) {
        this.vista = vista;
        catalogo = new ArrayList<>();
        carrito = new Carrito();
        historial = new CompraHistorial();
    }
    public void agregarProductoCatalogo() {
        String nombre = vista.solicitarTexto("Nombre del producto");
        double precio = vista.solicitarNumero("Precio del producto (S/)");
        catalogo.add(new Producto(nombre, precio));
        vista.mostrarMensaje(" Producto agregado al catálogo.");
    }
    public void listarProductos() {
        vista.mostrarProductos(catalogo);
    }
    public void agregarAlCarrito() {
        String nombre = vista.solicitarTexto("Nombre del producto a agregar");
        for (Producto p : catalogo) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                carrito.agregarProducto(p);
                vista.mostrarMensaje(" Producto agregado al carrito.");
                return;
            }
        }
        vista.mostrarMensaje(" Producto no encontrado en el catálogo.");
    }
    public void verCarrito() {
        List<Producto> productos = carrito.getProductos();
        vista.mostrarProductos(productos);
        vista.mostrarMensaje(" Total actual: S/ " + carrito.calcularTotal());
    }
    public void eliminarDelCarrito() {
        String nombre = vista.solicitarTexto("Nombre del producto a eliminar del carrito");
        boolean eliminado = carrito.eliminarProducto(nombre);
        if (eliminado) vista.mostrarMensaje(" Producto eliminado del carrito.");
        else vista.mostrarMensaje(" Producto no encontrado en el carrito.");
    }
    public void aplicarDescuento() {
        double monto = vista.solicitarNumero("Monto de descuento a aplicar (S/)");
        carrito.aplicarDescuento(monto);
        vista.mostrarMensaje(" Descuento aplicado: S/ " + monto);
    }
    public void calcularEnvio() {
        double distancia = vista.solicitarNumero("Distancia de envío en km");
        carrito.calcularEnvio(distancia);
        vista.mostrarMensaje(" Costo de envío: S/ " + carrito.getCostoEnvio());
    }
    public void realizarCompra() {
        if (carrito.estaVacio()) {
            vista.mostrarMensaje(" El carrito está vacío. No se puede realizar la compra.");
            return;
        }
        double total = carrito.calcularTotal();
        historial.registrarCompra(carrito.getProductos());
        carrito.vaciar();
        vista.mostrarMensaje(" Compra realizada por S/ " + total);
    }
    public void verHistorial() {
        List<List<Producto>> lista = historial.getHistorial();
        if (lista.isEmpty()) {
            vista.mostrarMensaje("No hay compras registradas.");
            return;
        }
        System.out.println("\n=== HISTORIAL DE COMPRAS ===");
        int num = 1;
        for (List<Producto> compra : lista) {
            System.out.println("Compra #" + num++);
            for (Producto p : compra) {
                System.out.println("- " + p);
            }
            System.out.println("--------------------------");
        }
    }
    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarTexto("Selecciona una opción");
            switch (opcion) {
                case "1": agregarProductoCatalogo(); break;
                case "2": listarProductos(); break;
                case "3": agregarAlCarrito(); break;
                case "4": verCarrito(); break;
                case "5": eliminarDelCarrito(); break;
                case "6": aplicarDescuento(); break;
                case "7": calcularEnvio(); break;
                case "8": realizarCompra(); break;
                case "9": verHistorial(); break;
                case "10": vista.mostrarMensaje(" Gracias por usar la tienda."); break;
                default: vista.mostrarMensaje(" Opción no válida.");
            }
        } while (!opcion.equals("10"));
        vista.cerrarScanner();
    }
}
