package controlador;

import modelo.Pedido;
import modelo.PedidoModelo;
import vista.PedidoVista;
import java.util.List;
public class PedidoControlador {
    private PedidoModelo modelo;
    private PedidoVista vista;
    public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    public void agregarPedido() {
        String nombre = vista.solicitarNombrePlato();
        String tipo = vista.solicitarTipoPlato();
        if (!nombre.isEmpty() && !tipo.isEmpty()) {
            modelo.agregarPedido(new Pedido(nombre, tipo));
            vista.mostrarMensaje(" Pedido agregado con estado Pendiente.");
        } else {
            vista.mostrarMensaje(" Los campos no pueden estar vacíos.");
        }
    }
    public void mostrarPendientes() {
        vista.mostrarPedidos(modelo.getPedidos());
    }
    public void marcarPedidoCompleto() {
        String nombre = vista.solicitarTexto("Introduce el nombre del pedido a marcar como completo");
        boolean completado = modelo.marcarComoCompleto(nombre);
        if (completado)
            vista.mostrarMensaje(" Pedido marcado como completo y movido al historial.");
        else
            vista.mostrarMensaje(" Pedido no encontrado o ya completado.");
    }
    public void eliminarPedido() {
        String nombre = vista.solicitarTexto("Introduce el nombre del pedido a eliminar");
        boolean eliminado = modelo.eliminarPedido(nombre);
        if (eliminado)
            vista.mostrarMensaje(" Pedido eliminado y movido al historial.");
        else
            vista.mostrarMensaje(" Pedido no encontrado.");
    }
    public void mostrarCompletos() {
        List<Pedido> completados = modelo.filtrarPorEstado("Completo");
        vista.mostrarPedidos(completados);
    }
    public void mostrarHistorial() {
        vista.mostrarPedidos(modelo.getHistorial());
    }
    public void contarPendientes() {
        int cantidad = modelo.contarPendientes();
        vista.mostrarMensaje(" Pedidos pendientes: " + cantidad);
    }
    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();
            switch (opcion) {
                case "1": agregarPedido(); break;
                case "2": mostrarPendientes(); break;
                case "3": marcarPedidoCompleto(); break;
                case "4": mostrarCompletos(); break;
                case "5": eliminarPedido(); break;
                case "6": mostrarHistorial(); break;
                case "7": contarPendientes(); break;
                case "8": vista.mostrarMensaje(" Saliendo..."); break;
                default: vista.mostrarMensaje(" Opción no válida.");
            }
        } while (!opcion.equals("8"));
        vista.cerrarScanner();
    }
}
