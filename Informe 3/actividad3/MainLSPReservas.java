package actividad3;

public class MainLSPReservas {
    public static void main(String[] args) {
        Habitacion h1 = new HabitacionEstandar("101");
        Habitacion h2 = new HabitacionSuite("202");
        Habitacion h3 = new HabitacionPremium("303");

        procesarReserva(h1);
        procesarReserva(h2);
        procesarReserva(h3);
    }

    // El controlador trabaja con la clase base Habitacion
    public static void procesarReserva(Habitacion habitacion) {
        habitacion.reservar();
        habitacion.liberar();
    }
}

