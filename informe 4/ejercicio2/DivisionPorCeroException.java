package ejercicio2;

// Excepción personalizada para división por cero
public class DivisionPorCeroException extends Exception {
    public DivisionPorCeroException(String mensaje) {
        super(mensaje);
    }
}
