package paquete;

public class CommandDemo {
    public static void main(String[] args) {
        Televisor tv = new Televisor();
        ControlRemoto control = new ControlRemoto();

        control.setComando(new EncenderCommand(tv)); 
        control.presionarBoton();

        control.setComando(new SubirVolumenCommand(tv)); 
        control.presionarBoton();

        control.setComando(new CambiarCanalCommand(tv)); 
        control.presionarBoton();
    }
}
