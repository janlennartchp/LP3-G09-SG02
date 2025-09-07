package actividad3;

public class HabitacionSuite extends Habitacion {

    public HabitacionSuite(String numero) {
        super(numero);
    }

    @Override
    public void reservar() {
        System.out.println("Suite " + numero + " reservada con acceso VIP.");
    }
}

