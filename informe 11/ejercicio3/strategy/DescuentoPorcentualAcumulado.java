package strategy;

import java.util.Comparator;
import java.util.List;

public class DescuentoPorcentualAcumulado implements Strategy {

    @Override
    public double aplicarDescuento(List<Producto> productos) {
        if (productos.size() >= 3) {
            Producto masBarato = productos.stream()
                                          .min(Comparator.comparingDouble(Producto::getPrecio))
                                          .get();

            double descuento = masBarato.getPrecio() * 0.50;

            double total = productos.stream().mapToDouble(Producto::getPrecio).sum();

            return total - descuento;
        }

        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }
}
