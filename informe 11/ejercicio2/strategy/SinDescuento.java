package strategy;

import java.util.List;

public class SinDescuento implements Strategy {

    @Override
    public double aplicarDescuento(List<Producto> productos) {
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }
}
