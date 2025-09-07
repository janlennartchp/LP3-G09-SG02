package actividad2;

import java.time.LocalDate;

public class Actividad2 {
    public static void main(String[] args) {
        // Crear habitación
        Habitacion suite = new Habitacion("Suite", 300.0);

        // Crear reservas con diferentes políticas
        Reserva reservaFlexible = new Reserva(
            suite,
            LocalDate.of(2024, 9, 20),
            LocalDate.of(2024, 9, 25),
            new PoliticaCancelacionFlexible()
        );

        Reserva reservaModerada = new Reserva(
            suite,
            LocalDate.of(2024, 9, 20),
            LocalDate.of(2024, 9, 25),
            new PoliticaCancelacionModerada()
        );

        Reserva reservaEstricta = new Reserva(
            suite,
            LocalDate.of(2024, 9, 20),
            LocalDate.of(2024, 9, 25),
            new PoliticaCancelacionEstricta()
        );

        // Probar cancelaciones en diferentes fechas
        LocalDate fechaPrueba = LocalDate.of(2024, 9, 18); // 2 días antes

        System.out.println("Cancelación Flexible (2 días antes): " + reservaFlexible.cancelar(fechaPrueba));
        System.out.println("Cancelación Moderada (2 días antes): " + reservaModerada.cancelar(fechaPrueba));
        System.out.println("Cancelación Estricta (2 días antes): " + reservaEstricta.cancelar(fechaPrueba));

        LocalDate fechaPrueba2 = LocalDate.of(2024, 9, 16); // 4 días antes
        System.out.println("Cancelación Moderada (4 días antes): " + reservaModerada.cancelar(fechaPrueba2));
    }
}
