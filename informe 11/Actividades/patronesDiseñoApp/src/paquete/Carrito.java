package paquete;

public class Carrito {
    private EstrategiaDescuento estrategia;

    public void setEstrategia(EstrategiaDescuento estrategia) {
        this.estrategia = estrategia;
    }

    public void calcular(double precio) {
        System.out.println("Precio final: " + estrategia.aplicarDescuento(precio));
    }
}
