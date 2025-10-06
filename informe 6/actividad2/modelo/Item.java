package modelo;

public class Item {
    private String nombre;
    private int cantidad;
    private String tipo; // Ejemplo: "Arma", "Poción"
    private String descripcion;
    public Item(String nombre, int cantidad, String tipo, String descripcion) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }
    public String getNombre() {
        return nombre;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public String getTipo() {
        return tipo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void usarItem() {
        if (cantidad > 0) {
            cantidad--;
            System.out.println("Usaste " + nombre + ". Cantidad restante: " + cantidad);
        } else {
            System.out.println("No queda más de este ítem.");
        }
    }
    @Override
    public String toString() {
        return nombre + " (" + tipo + ") - Cantidad: " + cantidad + " | " + descripcion;
    }
}
