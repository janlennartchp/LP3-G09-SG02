package paquete;

public class Televisor {
    private int volumen = 10;
    private int canal = 1;

    public void encender() {
        System.out.println("TV Encendido");
    }

    public void apagar() {
        System.out.println("TV Apagado");
    }

    public void subirVolumen() {
        volumen++;
        System.out.println("Volumen: " + volumen);
    }

    public void bajarVolumen() {
        volumen--;
        System.out.println("Volumen: " + volumen);
    }

    public void cambiarCanal() {
        canal++;
        System.out.println("Canal: " + canal);
    }
}
