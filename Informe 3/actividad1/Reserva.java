package actividad1;

import java.time.LocalDate;

public class Reserva {
    private Habitacion habitacion;
    private Cliente cliente;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Reserva(Habitacion habitacion, Cliente cliente, LocalDate fechaInicio, LocalDate fechaFin) {
        this.habitacion = habitacion;
        this.cliente = cliente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public boolean seSuperpone(LocalDate inicio, LocalDate fin) {
        return !(fin.isBefore(fechaInicio) || inicio.isAfter(fechaFin));
    }

    public Habitacion getHabitacion() { return habitacion; }
    public Cliente getCliente() { return cliente; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
}
