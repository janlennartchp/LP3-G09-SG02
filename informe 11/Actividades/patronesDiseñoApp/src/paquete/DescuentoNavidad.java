package paquete;

public class DescuentoNavidad implements EstrategiaDescuento {
    @Override
    public double aplicarDescuento(double precio) {
        return precio * 0.80; // 20% menos
    }
}
