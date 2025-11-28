package observer;

public class MainObserver {

    public static void main(String[] args) {

        Notificacion sistema = new Notificacion();

        Usuario u1 = new Usuario("Carlos");
        Usuario u2 = new Usuario("María");
        Usuario u3 = new Usuario("José");

        sistema.attach(u1);
        sistema.attach(u2);
        sistema.attach(u3);

        System.out.println("Enviando Notificación 1 ");
        sistema.nuevoEvento("Nueva promoción disponible!");

        System.out.println(" María se desuscribe ");
        sistema.detach(u2);

        System.out.println("Enviando Notificación 2 ");
        sistema.nuevoEvento("Producto en oferta!");
    }
}
