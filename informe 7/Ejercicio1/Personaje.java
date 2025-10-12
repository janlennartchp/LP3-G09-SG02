import java.io.Serializable;

public class Personaje implements Serializable {
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int alcance;

    public Personaje(String nombre, int vida, int ataque, int defensa, int alcance) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.alcance = alcance;
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
        return nombre + "," + vida + "," + ataque + "," + defensa + "," + alcance;
    }

    public static Personaje fromString(String linea) {
        String[] partes = linea.split(",");
        if (partes.length == 5) {
            String nombre = partes[0];
            int vida = Integer.parseInt(partes[1]);
            int ataque = Integer.parseInt(partes[2]);
            int defensa = Integer.parseInt(partes[3]);
            int alcance = Integer.parseInt(partes[4]);
            return new Personaje(nombre, vida, ataque, defensa, alcance);
        }
        return null;
    }
}
