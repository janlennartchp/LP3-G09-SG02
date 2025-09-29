package actividad2;
public class Pila<E> {
    private final int tamanio; // número de elementos en la pila
    private int superior; // ubicación del elemento superior
    private E[] elementos; // arreglo que almacena los elementos de la pila

    public Pila() {
        this(10);
    }

    @SuppressWarnings("unchecked")
    public Pila(int s) {
        tamanio = s > 0 ? s : 10;
        superior = -1;
        elementos = (E[]) new Object[tamanio];
    }

    public void push(E valorAMeter) throws ExcepcionPilaLlena {
        if (superior == tamanio - 1)
            throw new ExcepcionPilaLlena("La pila está llena, no se puede meter " + valorAMeter);
        elementos[++superior] = valorAMeter;
    }

    public E pop() throws ExcepcionPilaVacia {
        if (superior == -1)
            throw new ExcepcionPilaVacia("Pila vacía, no se puede sacar");
        return elementos[superior--];
    }

    public boolean contains(E elemento) {
        for (int i = superior; i >= 0; i--) {
            if (elementos[i].equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    public static class ExcepcionPilaLlena extends Exception {
        public ExcepcionPilaLlena(String mensaje) {
            super(mensaje);
        }
    }

    public static class ExcepcionPilaVacia extends Exception {
        public ExcepcionPilaVacia(String mensaje) {
            super(mensaje);
        }
    }

    public static void main(String[] args) {
        try {
            Pila<Integer> pila = new Pila<>(5);
            pila.push(10);
            pila.push(20);
            pila.push(30);

            System.out.println("¿La pila contiene 20? " + pila.contains(20));
            System.out.println("¿La pila contiene 40? " + pila.contains(40));

            System.out.println("Elemento extraído: " + pila.pop());
            System.out.println("Elemento extraído: " + pila.pop());

        } catch (ExcepcionPilaLlena e) {
            System.err.println(e.getMessage());
        } catch (ExcepcionPilaVacia e) { // ahora sí puede alcanzarse porque usamos pop
            System.err.println(e.getMessage());
        }
    }
}
