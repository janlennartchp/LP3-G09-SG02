package actividad3;

public abstract class Habitacion {
    protected String numero;

    public Habitacion(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    // Método base que TODAS las habitaciones deben cumplir
    public abstract void reservar();

    // Método opcional común
    public void liberar() {
        System.out.println("La habitación " + numero + " ha sido liberada.");
    }
}

