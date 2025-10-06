package modelo;

import java.util.ArrayList;
import java.util.List;
public class PedidoModelo {
    private List<Pedido> pedidos;
    public PedidoModelo() {
        pedidos = new ArrayList<>();
    }
    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }
    public List<Pedido> getPedidos() {
        return pedidos;
    }
    public boolean eliminarPedido(String nombre) {
        for (Pedido p : pedidos) {
            if (p.getNombrePlato().equalsIgnoreCase(nombre)) {
                pedidos.remove(p);
                return true;
            }
        }
        return false;
    }
    public boolean actualizarPedido(String nombreViejo, String nuevoNombre) {
        for (Pedido p : pedidos) {
            if (p.getNombrePlato().equalsIgnoreCase(nombreViejo)) {
                p.setNombrePlato(nuevoNombre);
                return true;
            }
        }
        return false;
    }
    public List<Pedido> buscarPorNombreOTipo(String texto) {
        List<Pedido> resultados = new ArrayList<>();
        for (Pedido p : pedidos) {
            if (p.getNombrePlato().equalsIgnoreCase(texto) ||
                p.getTipoPlato().equalsIgnoreCase(texto)) {
                resultados.add(p);
            }
        }
        return resultados;
    }
    public int contarPedidos() {
        return pedidos.size();
    }
    public int contarPorTipo(String tipo) {
        int contador = 0;
        for (Pedido p : pedidos) {
            if (p.getTipoPlato().equalsIgnoreCase(tipo)) {
                contador++;
            }
        }
        return contador;
    }
}
