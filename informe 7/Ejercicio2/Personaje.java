import java.io.Serializable;
import java.util.Random;

public class Personaje implements Serializable {
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int alcance;
    private int nivel;

    public Personaje(String nombre, int vida, int ataque, int defensa, int alcance) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.alcance = alcance;
        this.nivel = 1;
    }

    public static Personaje generarAleatorio() {
        String[] nombres = {"Caballero", "Guerrero", "Arquero", "Mago", "Asesino", "Tanque"};
        Random r = new Random();
        String nombre = nombres[r.nextInt(nombres.length)];
        int vida = r.nextInt(5) + 1;
        int ataque = r.nextInt(5) + 1;
        int defensa = r.nextInt(5) + 1;
        int alcance = r.nextInt(5) + 1;
        return new Personaje(nombre, vida, ataque, defensa, alcance);
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getAlcance() {
        return alcance;
    }

    public int getNivel() {
        return nivel;
    }

    public void subirNivel() {
        nivel++;
        vida += 1;
        ataque += 1;
        defensa += 1;
        alcance += 1;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }

    @Override
    public String toString() {
        return nombre + "," + vida + "," + ataque + "," + defensa + "," + alcance + "," + nivel;
    }

    public static Personaje fromString(String linea) {
        String[] partes = linea.split(",");
        if (partes.length >= 6) {
            String nombre = partes[0];
            int vida = Integer.parseInt(partes[1]);
            int ataque = Integer.parseInt(partes[2]);
            int defensa = Integer.parseInt(partes[3]);
            int alcance = Integer.parseInt(partes[4]);
            int nivel = Integer.parseInt(partes[5]);
            Personaje p = new Personaje(nombre, vida, ataque, defensa, alcance);
            p.nivel = nivel;
            return p;
        }
        return null;
    }
}
