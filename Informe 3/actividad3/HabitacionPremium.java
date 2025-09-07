package actividad3;

public class HabitacionPremium extends Habitacion {

    public HabitacionPremium(String numero) {
        super(numero);
    }

    @Override
    public void reservar() {
        System.out.println("Habitación Premium " + numero + " reservada con desayuno incluido.");
    }
}

