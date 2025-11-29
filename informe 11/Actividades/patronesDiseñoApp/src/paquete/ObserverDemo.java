package paquete;

public class ObserverDemo {
    public static void main(String[] args) {
        Notificador notificador = new Notificador();

        Observador u1 = new Usuario("Jan");
        Observador u2 = new Usuario("Luis");
        Observador u3 = new Usuario("Carla");

        notificador.agregarUsuario(u1);
        notificador.agregarUsuario(u2);
        notificador.agregarUsuario(u3);

        notificador.notificar("¡Nueva oferta disponible!");
    }
}
