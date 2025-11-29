package paquete;

public class SinDescuento implements EstrategiaDescuento {
    @Override
    public double aplicarDescuento(double precio) {
        return precio; // sin descuento
    }
}
