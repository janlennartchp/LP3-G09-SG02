package modelo;

import java.util.ArrayList;
import java.util.List;

public class CompraHistorial {
    private List<List<Producto>> historial;

    public CompraHistorial() {
        historial = new ArrayList<>();
    }

    public void registrarCompra(List<Producto> productosComprados) {
        historial.add(new ArrayList<>(productosComprados)); // copia de la compra
    }

    public List<List<Producto>> getHistorial() {
        return historial;
    }
}
