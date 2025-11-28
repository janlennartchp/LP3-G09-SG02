package strategy;

import java.util.List;

public class DescuentoPorcentual implements Strategy {

    @Override
    public double aplicarDescuento(List<Producto> productos) {

        if (productos.size() == 2 &&
            productos.get(0).getNombre().equals(productos.get(1).getNombre())) {

            double total = productos.stream().mapToDouble(Producto::getPrecio).sum();
            return total * 0.70; // 30% de descuento
        }

        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }
}
