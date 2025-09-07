package actividad2;

import java.time.LocalDate;

public class PoliticaCancelacionFlexible implements PoliticaCancelacion {
    @Override
    public boolean puedeCancelar(Reserva reserva, LocalDate fechaActual) {
        // Se puede cancelar hasta 24h antes del check-in
        return fechaActual.isBefore(reserva.getFechaCheckIn().minusDays(1));
    }
}