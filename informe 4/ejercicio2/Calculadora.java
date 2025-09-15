package ejercicio2;

// Clase Calculadora que realiza operaciones matemáticas
public class Calculadora {

    // Método para realizar la suma
    public double sumar(double a, double b) {
        return a + b;
    }

    // Método para realizar la resta
    public double restar(double a, double b) {
        return a - b;
    }

    // Método para realizar la multiplicación
    public double multiplicar(double a, double b) {
        return a * b;
    }

    // Método para realizar la división
    public double dividir(double a, double b) throws DivisionPorCeroException {
        if (b == 0) {
            throw new DivisionPorCeroException("Error: No se puede dividir por cero.");
        }
        return a / b;
    }
}

