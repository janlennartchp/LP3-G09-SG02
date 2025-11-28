package observer;

public class Notificacion extends Subject {

    public void nuevoEvento(String mensaje) {
        notifyObservers(mensaje);
    }
}
