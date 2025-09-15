package ejercicio2;

public class PruebaCalculadora {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        try {
            // Probando suma
            System.out.println("Suma: " + calculadora.sumar(5, 3));

            // Probando resta
            System.out.println("Resta: " + calculadora.restar(5, 3));

            // Probando multiplicación
            System.out.println("Multiplicación: " + calculadora.multiplicar(5, 3));

            // Probando división válida
            System.out.println("División: " + calculadora.dividir(6, 2));

            // Probando división por cero (esto lanzará la excepción personalizada)
            System.out.println("División: " + calculadora.dividir(6, 0));

        } catch (IllegalArgumentException e) {
            // Captura de IllegalArgumentException
            System.out.println("Error: Argumento inválido - " + e.getMessage());
        } catch (ArithmeticException e) {
            // Captura de ArithmeticException (por ejemplo, división por cero estándar)
            System.out.println("Error: Excepción aritmética - " + e.getMessage());
        } catch (DivisionPorCeroException e) {
            // Captura de nuestra excepción personalizada DivisionPorCeroException
            System.out.println(e.getMessage());
        } catch (Exception e) {
            // Captura de cualquier otra excepción no prevista
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}

