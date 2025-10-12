import java.io.*;
import java.util.*;

public class Gestor {
    private List<Personaje> personajes;
    private final String archivo = "personajes.txt";

    public Gestor() {
        personajes = new ArrayList<>();
        cargarDesdeArchivo();
    }

    private void cargarDesdeArchivo() {
        personajes.clear();
        File file = new File(archivo);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Personaje p = Personaje.fromString(linea);
                if (p != null) personajes.add(p);
            }
        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
    }

    private void guardarEnArchivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Personaje p : personajes) {
                bw.write(p.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar archivo: " + e.getMessage());
        }
    }

    public void agregarPersonaje(Personaje p) {
        for (Personaje existente : personajes) {
            if (existente.getNombre().equalsIgnoreCase(p.getNombre())) {
                System.out.println(" El personaje '" + p.getNombre() + "' ya existe.");
                return;
            }
        }
        personajes.add(p);
        guardarEnArchivo();
        System.out.println(" Personaje agregado correctamente.");
    }

    public void mostrarPersonajes() {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes registrados.");
            return;
        }
        System.out.println("\n Lista de personajes:");
        for (Personaje p : personajes) {
            System.out.println("Nombre: " + p.getNombre() +
                               " | Vida: " + p.getVida() +
                               " | Ataque: " + p.getAtaque() +
                               " | Defensa: " + p.getDefensa() +
                               " | Alcance: " + p.getAlcance());
        }
    }

    public void modificarPersonaje(String nombre, int vida, int ataque, int defensa, int alcance) {
        for (Personaje p : personajes) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                p.setVida(vida);
                p.setAtaque(ataque);
                p.setDefensa(defensa);
                p.setAlcance(alcance);
                guardarEnArchivo();
                System.out.println(" Personaje modificado correctamente.");
                return;
            }
        }
        System.out.println("Personaje no encontrado.");
    }

    public void eliminarPersonaje(String nombre) {
        Iterator<Personaje> it = personajes.iterator();
        while (it.hasNext()) {
            Personaje p = it.next();
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                it.remove();
                guardarEnArchivo();
                System.out.println("️ Personaje eliminado correctamente.");
                return;
            }
        }
        System.out.println("rsonaje no encontrado.");
    }
}
