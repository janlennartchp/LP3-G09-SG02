package observer;
public class MainObserver{
    public static void main(String[] args){
        Notificacion sistema=new Notificacion();
        Usuario u1=new Usuario("Carlos");
        Usuario u2=new Usuario("María");
        sistema.attach(u1); sistema.attach(u2);
        sistema.nuevoEvento("¡Nueva promoción disponible!");
        sistema.detach(u2);
        sistema.nuevoEvento("¡Producto nuevo agregado!");
    }
}