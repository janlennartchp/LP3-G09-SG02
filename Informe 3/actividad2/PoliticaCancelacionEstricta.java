package actividad2;

import java.time.LocalDate;

public class PoliticaCancelacionEstricta implements PoliticaCancelacion {
    @Override
    public boolean puedeCancelar(Reserva reserva, LocalDate fechaActual) {
        // Nunca se permite cancelar
        return false;
    }
}
