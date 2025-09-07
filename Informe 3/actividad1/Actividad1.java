package actividad1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Actividad1 {
    public static void main(String[] args) {
        // Lista de reservas inicial
        List<Reserva> reservas = new ArrayList<>();
        GestorDisponibilidadHabitacion gestor = new GestorDisponibilidadHabitacion(reservas);

        // Crear habitaciones
        Habitacion habitacion1 = new Habitacion("Doble", 150.0, gestor);
        Habitacion habitacion2 = new Habitacion("Suite", 300.0, gestor);

        // Crear clientes
        Cliente cliente1 = new Cliente("Juan Pérez", "juanperez@email.com");
        Cliente cliente2 = new Cliente("María López", "marialopez@email.com");

        // Crear una reserva existente para cliente1
        Reserva reserva1 = new Reserva(habitacion1, cliente1,
                LocalDate.of(2024, 9, 10),
                LocalDate.of(2024, 9, 15));
        reservas.add(reserva1);

        // Verificar disponibilidad
        boolean disponible1 = habitacion1.estaDisponible(LocalDate.of(2024, 9, 12), LocalDate.of(2024, 9, 14));
        System.out.println("¿Habitación Doble disponible entre 12 y 14 de septiembre? " + disponible1);

        boolean disponible2 = habitacion1.estaDisponible(LocalDate.of(2024, 9, 16), LocalDate.of(2024, 9, 18));
        System.out.println("¿Habitación Doble disponible entre 16 y 18 de septiembre? " + disponible2);

        // Intentar reservar la Suite para cliente2
        habitacion2.reservar(cliente2, LocalDate.of(2024, 9, 20), LocalDate.of(2024, 9, 25));

        // Liberar habitación1
        habitacion1.liberar();
        System.out.println("Habitación Doble liberada.");
    }
}
