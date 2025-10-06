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
            vista.mostrarMensaje("✅ Pedido agregado: " + nombre + " (" + tipo + ")");
        } else {
            vista.mostrarMensaje("⚠️ Los campos no pueden estar vacíos.");
        }
    }
    public void mostrarPedidos() {
        vista.mostrarPedidos(modelo.getPedidos());
    }
    public void eliminarPedido() {
        String nombre = vista.solicitarTexto("Introduce el nombre del pedido a eliminar");
        boolean eliminado = modelo.eliminarPedido(nombre);
        if (eliminado)
            vista.mostrarMensaje(" Pedido eliminado correctamente.");
        else
            vista.mostrarMensaje(" Pedido no encontrado.");
    }
    public void actualizarPedido() {
        String nombreViejo = vista.solicitarTexto("Introduce el nombre actual del pedido");
        String nuevoNombre = vista.solicitarTexto("Introduce el nuevo nombre del pedido");
        boolean actualizado = modelo.actualizarPedido(nombreViejo, nuevoNombre);
        if (actualizado)
            vista.mostrarMensaje(" Pedido actualizado correctamente.");
        else
            vista.mostrarMensaje(" Pedido no encontrado.");
    }
    public void buscarPedido() {
        String texto = vista.solicitarTexto("Introduce el nombre o tipo del pedido a buscar");
        List<Pedido> resultados = modelo.buscarPorNombreOTipo(texto);
        if (resultados.isEmpty())
            vista.mostrarMensaje(" No se encontraron coincidencias.");
        else
            vista.mostrarPedidos(resultados);
    }
    public void contarPedidos() {
        int total = modelo.contarPedidos();
        vista.mostrarMensaje(" Total de pedidos: " + total);

        String tipo = vista.solicitarTexto("Introduce un tipo para contar (por ejemplo: Fondo)");
        int cantidadTipo = modelo.contarPorTipo(tipo);
        vista.mostrarMensaje(" Pedidos de tipo '" + tipo + "': " + cantidadTipo);
    }
    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();
            switch (opcion) {
                case "1": agregarPedido(); break;
                case "2": mostrarPedidos(); break;
                case "3": eliminarPedido(); break;
                case "4": actualizarPedido(); break;
                case "5": buscarPedido(); break;
                case "6": contarPedidos(); break;
                case "7": vista.mostrarMensaje("👋 Saliendo..."); break;
                default: vista.mostrarMensaje("❌ Opción no válida.");
            }
        } while (!opcion.equals("7"));
        vista.cerrarScanner();
    }
}
