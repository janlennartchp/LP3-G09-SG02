package modelo;

import java.util.ArrayList;
import java.util.List;
public class PedidoModelo {
    private List<Pedido> pedidos;
    private List<Pedido> historial;
    public PedidoModelo() {
        pedidos = new ArrayList<>();
        historial = new ArrayList<>();
    }
    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }
    public List<Pedido> getPedidos() {
        return pedidos;
    }
    public List<Pedido> getHistorial() {
        return historial;
    }
    public boolean eliminarPedido(String nombre) {
        for (Pedido p : pedidos) {
            if (p.getNombrePlato().equalsIgnoreCase(nombre)) {
                p.setEstado("Eliminado");
                historial.add(p);
                pedidos.remove(p);
                return true;
            }
        }
        return false;
    }
    public boolean marcarComoCompleto(String nombre) {
        for (Pedido p : pedidos) {
            if (p.getNombrePlato().equalsIgnoreCase(nombre) && p.getEstado().equals("Pendiente")) {
                p.setEstado("Completo");
                historial.add(p);
                pedidos.remove(p);
                return true;
            }
        }
        return false;
    }
    public List<Pedido> filtrarPorEstado(String estado) {
        List<Pedido> resultado = new ArrayList<>();
        for (Pedido p : historial) {
            if (p.getEstado().equalsIgnoreCase(estado)) {
                resultado.add(p);
            }
        }
        return resultado;
    }
    public int contarPendientes() {
        int contador = 0;
        for (Pedido p : pedidos) {
            if (p.getEstado().equalsIgnoreCase("Pendiente")) {
                contador++;
            }
        }
        return contador;
    }
}
