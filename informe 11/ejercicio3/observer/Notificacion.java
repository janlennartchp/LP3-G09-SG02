package observer;
public class Notificacion extends Subject{
    public void nuevoEvento(String m){ notifyObservers(m);}
}