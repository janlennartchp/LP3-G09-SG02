package actividad2;

// Excepción personalizada para cuenta no encontrada
public class CuentaNoEncontradaException extends Exception {
    public CuentaNoEncontradaException(String message) {
        super(message);
    }
}

