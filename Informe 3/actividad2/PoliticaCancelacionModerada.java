package actividad2;

import java.time.LocalDate;

public class PoliticaCancelacionModerada implements PoliticaCancelacion {
    @Override
    public boolean puedeCancelar(Reserva reserva, LocalDate fechaActual) {
        // Se puede cancelar hasta 72h antes (3 días) con penalización
        return fechaActual.isBefore(reserva.getFechaCheckIn().minusDays(3));
    }
}
