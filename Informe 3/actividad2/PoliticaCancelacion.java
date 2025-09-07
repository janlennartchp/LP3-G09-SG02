package actividad2;

import java.time.LocalDate;

public interface PoliticaCancelacion {
    boolean puedeCancelar(Reserva reserva, LocalDate fechaActual);
}
