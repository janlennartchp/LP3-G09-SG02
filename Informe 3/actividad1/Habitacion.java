package actividad1;

import java.time.LocalDate;

public class Habitacion {
    private String tipo;
    private double precioBase;
    private boolean disponible;
    private GestorDisponibilidadHabitacion gestor;

    public Habitacion(String tipo, double precioBase, GestorDisponibilidadHabitacion gestor) {
        this.tipo = tipo;
        this.precioBase = precioBase;
        this.disponible = true;
        this.gestor = gestor;
    }

    public boolean estaDisponible(LocalDate inicio, LocalDate fin) {
        return gestor.verificarDisponibilidad(this, inicio, fin);
    }

    public void reservar(Cliente cliente, LocalDate inicio, LocalDate fin) {
        if (estaDisponible(inicio, fin)) {
            gestor.marcarReservada(this);
            gestor.agregarReserva(new Reserva(this, cliente, inicio, fin));
            System.out.println("✅ Reserva confirmada para " + cliente.getNombre() +
                               " en habitación " + tipo +
                               " desde " + inicio + " hasta " + fin);
        } else {
            System.out.println("La habitación " + tipo + " no está disponible en ese rango de fechas.");
        }
    }

    public void liberar() {
        gestor.marcarDisponible(this);
    }

    // Getters y Setters
    public String getTipo() { return tipo; }
    public double getPrecioBase() { return precioBase; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}
