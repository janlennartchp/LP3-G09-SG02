package actividad2;

import java.time.LocalDate;

public class Reserva {
    private Habitacion habitacion;
    private LocalDate fechaCheckIn;
    private LocalDate fechaCheckOut;
    private PoliticaCancelacion politica;

    public Reserva(Habitacion habitacion, LocalDate fechaCheckIn, LocalDate fechaCheckOut, PoliticaCancelacion politica) {
        this.habitacion = habitacion;
        this.fechaCheckIn = fechaCheckIn;
        this.fechaCheckOut = fechaCheckOut;
        this.politica = politica;
    }

    public boolean cancelar(LocalDate fechaActual) {
        return politica.puedeCancelar(this, fechaActual);
    }

    // Getters
    public LocalDate getFechaCheckIn() { return fechaCheckIn; }
    public LocalDate getFechaCheckOut() { return fechaCheckOut; }
    public Habitacion getHabitacion() { return habitacion; }
}
