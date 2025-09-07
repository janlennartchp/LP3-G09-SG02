package actividad5;

public class MainDIP {
    public static void main(String[] args) {
        CanalNotificacion correo = new EnviadorCorreo();
        NotificadorReserva notificador1 = new NotificadorReserva(correo);
        notificador1.notificar("Su reserva ha sido confirmada por correo.");

        CanalNotificacion sms = new EnviadorSMS();
        NotificadorReserva notificador2 = new NotificadorReserva(sms);
        notificador2.notificar("Su reserva ha sido confirmada por SMS.");
    }
}

