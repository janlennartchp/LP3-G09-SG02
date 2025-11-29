package paquete;

public class AppFinal {
    public static void main(String[] args) {
        // Observer
        Notificador notificador = new Notificador();
        notificador.agregarUsuario(new Usuario("Jan"));
        notificador.agregarUsuario(new Usuario("Carla"));

        // Strategy
        Carrito carrito = new Carrito();
        carrito.setEstrategia(new DescuentoBlackFriday());

        // Command -> usar lambda para simplificar
        Comando promocionCommand = () -> {
            carrito.calcular(150);
            notificador.notificar("¡Se aplicó descuento Black Friday al producto!");
        };

        // Invoker
        ControlRemoto controlPromo = new ControlRemoto();
        controlPromo.setComando(promocionCommand);

        System.out.println("== Aplicación Integrada ==");
        controlPromo.presionarBoton();
    }
}
