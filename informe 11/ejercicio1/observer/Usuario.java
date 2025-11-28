package observer;
public class Usuario implements Observer{
    private String nombre;
    public Usuario(String nombre){ this.nombre=nombre;}
    public void update(String m){ System.out.println("Notificación para "+nombre+": "+m);}
}