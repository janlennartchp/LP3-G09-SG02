package paquete;

public class DescuentoBlackFriday implements EstrategiaDescuento {
    @Override
    public double aplicarDescuento(double precio) {
        return precio * 0.50; // 50% menos
    }
}
