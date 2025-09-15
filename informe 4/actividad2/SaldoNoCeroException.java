package actividad2;

// Excepción personalizada para saldo no cero
public class SaldoNoCeroException extends Exception {
    public SaldoNoCeroException(String message) {
        super(message);
    }
}
