package modelo;

import java.util.ArrayList;
import java.util.List;
public class Carrito {
    private List<Producto> productos;
    private double descuento;
    private double costoEnvio;
    public Carrito() {
        productos = new ArrayList<>();
        descuento = 0;
        costoEnvio = 0;
    }
    public void agregarProducto(Producto p) {
        productos.add(p);
    }
    public boolean eliminarProducto(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                productos.remove(p);
                return true;
            }
        }
        return false;
    }
    public List<Producto> getProductos() {
        return productos;
    }
    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }
        total -= descuento;
        total += costoEnvio;
        return Math.max(total, 0);
    }
    public void aplicarDescuento(double monto) {
        descuento = monto;
    }
    public void calcularEnvio(double distanciaKm) {
        costoEnvio = distanciaKm * 2.5; // Ejemplo: S/2.5 por km
    }
    public double getDescuento() { return descuento; }
    public double getCostoEnvio() { return costoEnvio; }
    public void vaciar() {
        productos.clear();
        descuento = 0;
        costoEnvio = 0;
    }
    public boolean estaVacio() {
        return productos.isEmpty();
    }
}
