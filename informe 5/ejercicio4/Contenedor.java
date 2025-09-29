package ejercicio4;

// Archivo: Contenedor.java
import java.util.ArrayList;
import java.util.List;

// Clase genérica Contenedor<F, S>
public class Contenedor<F, S> {
    private List<Par<F, S>> listaPares;

    public Contenedor() {
        listaPares = new ArrayList<>();
    }

    public void agregarPar(F primero, S segundo) {
        listaPares.add(new Par<>(primero, segundo));
    }

    public Par<F, S> obtenerPar(int indice) {
        if (indice >= 0 && indice < listaPares.size()) {
            return listaPares.get(indice);
        } else {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
    }

    public List<Par<F, S>> obtenerTodosLosPares() {
        return listaPares;
    }

    public void mostrarPares() {
        for (Par<F, S> par : listaPares) {
            System.out.println(par);
        }
    }
}

