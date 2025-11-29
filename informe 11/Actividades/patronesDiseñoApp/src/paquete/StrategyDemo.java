package paquete;

public class StrategyDemo {
    public static void main(String[] args) {
        Carrito carrito = new Carrito();

        carrito.setEstrategia(new DescuentoNavidad());
        carrito.calcular(100);

        carrito.setEstrategia(new DescuentoBlackFriday());
        carrito.calcular(200);
    }
}
