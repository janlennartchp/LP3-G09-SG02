package actividad4;

import java.util.ArrayList;

class Pila<E> {
    private ArrayList<E> elementos;

    public Pila() {
        elementos = new ArrayList<>();
    }

    public void push(E elemento) {
        elementos.add(elemento);
    }

    public E pop() {
        if (elementos.isEmpty()) {
            throw new RuntimeException("La pila está vacía");
        }
        return elementos.remove(elementos.size() - 1);
    }

    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    public int size() {
        return elementos.size();
    }

    // Método genérico esIgual para comparar dos pilas
    public boolean esIgual(Pila<E> otraPila) {
        if (this.size() != otraPila.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            E elem1 = this.elementos.get(i);
            E elem2 = otraPila.elementos.get(i);
            if (elem1 == null) {
                if (elem2 != null) return false;
            } else if (!elem1.equals(elem2)) {
                return false;
            }
        }
        return true;
    }
}
