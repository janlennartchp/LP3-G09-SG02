package actividad1;
public class Actividad1 {

    public static <E> void imprimirArreglo(E[] arregloEntrada) {
        for (E elemento : arregloEntrada) {
            System.out.printf("%s ", elemento);
        }
        System.out.println();
    }

    public static <E> int imprimirArreglo(E[] arregloEntrada, int subindiceInferior, int subindiceSuperior)
            throws InvalidSubscriptException {

        if (subindiceInferior < 0 || subindiceSuperior >= arregloEntrada.length ||
            subindiceSuperior <= subindiceInferior) {
            throw new InvalidSubscriptException("Índices inválidos: [" + subindiceInferior + ", " + subindiceSuperior + "]");
        }

        int cantidad = 0;
        for (int i = subindiceInferior; i <= subindiceSuperior; i++) {
            System.out.printf("%s ", arregloEntrada[i]);
            cantidad++;
        }
        System.out.println();
        return cantidad;
    }

    static class InvalidSubscriptException extends Exception {
        public InvalidSubscriptException(String mensaje) {
            super(mensaje);
        }
    }

    public static void main(String[] args) {
        Integer[] arregloInteger = {1, 2, 3, 4, 5, 6};
        Double[] arregloDouble = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
        Character[] arregloCharacter = {'H', 'O', 'L', 'A'};

        System.out.println("Arreglo Integer completo:");
        imprimirArreglo(arregloInteger);

        System.out.println("\nArreglo Double completo:");
        imprimirArreglo(arregloDouble);

        System.out.println("\nArreglo Character completo:");
        imprimirArreglo(arregloCharacter);

        try {
            System.out.println("\nArreglo Integer del índice 1 al 4:");
            int cantidad = imprimirArreglo(arregloInteger, 1, 4);
            System.out.println("Elementos impresos: " + cantidad);
        } catch (InvalidSubscriptException e) {
            System.err.println(e.getMessage());
        }
    }
}