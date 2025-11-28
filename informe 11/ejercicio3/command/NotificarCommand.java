package command;

import observer.Notificacion;

public class NotificarCommand implements Command {

    private Notificacion sistema;
    private String mensaje;

    public NotificarCommand(Notificacion sistema, String mensaje) {
        this.sistema = sistema;
        this.mensaje = mensaje;
    }

    @Override
    public void execute() {
        sistema.nuevoEvento(mensaje);
    }
}
