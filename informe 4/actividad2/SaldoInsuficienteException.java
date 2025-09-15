package actividad2;

// Excepción personalizada para saldo insuficiente
public class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String message) {
        super(message);
    }
}
