package modelo;

import java.util.Random;

public class Enemigo {
    private String nombre;
    private int salud;
    private int nivel;
    private String tipo;

    public Enemigo(String nombre, int nivel, String tipo) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.tipo = tipo;
        this.salud = 80 + (nivel * 10);
    }

    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public int getNivel() { return nivel; }
    public String getTipo() { return tipo; }

    public void atacar(Jugador jugador) {
        Random rand = new Random();
        int daño = 5 + rand.nextInt(10) + (nivel * 2);
        System.out.println("😈 " + nombre + " ataca a " + jugador.getNombre() + " causando " + daño + " de daño.");
        jugador.recibirDaño(daño);
    }

    public void recibirDaño(int daño) {
        salud -= daño;
        if (salud < 0) salud = 0;
        System.out.println("🔥 " + nombre + " recibió " + daño + " de daño. Salud restante: " + salud);
    }

    public boolean estaVivo() {
        return salud > 0;
    }
}
