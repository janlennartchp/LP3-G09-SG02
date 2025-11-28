package strategy;

import java.util.List;

public class CalculadoraDePrecios {

    private Strategy estrategia;

    public void setStrategy(Strategy estrategia) {
        this.estrategia = estrategia;
    }

    public double calcularPrecio(List<Producto> productos) {
        return estrategia.aplicarDescuento(productos);
    }
}
