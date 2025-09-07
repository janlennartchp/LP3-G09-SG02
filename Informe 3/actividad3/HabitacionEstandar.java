package actividad3;

public class HabitacionEstandar extends Habitacion {

    public HabitacionEstandar(String numero) {
        super(numero);
    }

    @Override
    public void reservar() {
        System.out.println("Habitación estándar " + numero + " reservada.");
    }
}

