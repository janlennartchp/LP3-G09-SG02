package actividad1;

import java.time.LocalDate;
import java.util.List;

public class GestorDisponibilidadHabitacion {
    private List<Reserva> reservas;

    public GestorDisponibilidadHabitacion(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public boolean verificarDisponibilidad(Habitacion habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
        for (Reserva reserva : reservas) {
            if (reserva.getHabitacion().equals(habitacion) &&
                reserva.seSuperpone(fechaInicio, fechaFin)) {
                return false;
            }
        }
        return true;
    }

    public void marcarReservada(Habitacion habitacion) {
        habitacion.setDisponible(false);
    }

    public void marcarDisponible(Habitacion habitacion) {
        habitacion.setDisponible(true);
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }
}