package actividad3;

public class LimiteCreditoExcedidoException extends RuntimeException {
    public LimiteCreditoExcedidoException(String mensaje) {
        super(mensaje);
    }
}

