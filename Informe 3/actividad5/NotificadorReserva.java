package actividad5;

public class NotificadorReserva {
    private CanalNotificacion canal;

    public NotificadorReserva(CanalNotificacion canal) {
        this.canal = canal; // Inyección de dependencia
    }

    public void notificar(String mensaje) {
        canal.enviarNotificacion(mensaje);
    }
}
