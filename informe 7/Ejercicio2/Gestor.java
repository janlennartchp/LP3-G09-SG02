import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Gestor {
    private List<Personaje> personajes;
    private final String archivo = "personajes.txt";

    public Gestor() {
        personajes = new ArrayList<>();
        cargarDesdeArchivo();
        cargarPersonajesAleatorios();
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
                System.out.println("El personaje '" + p.getNombre() + "' ya existe.");
                return;
            }
        }
        personajes.add(p);
        guardarEnArchivo();
        System.out.println("Personaje agregado correctamente.");
    }

    public void mostrarPersonajes() {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes registrados.");
            return;
        }
        System.out.println("\nLista de personajes:");
        for (Personaje p : personajes) {
            System.out.println(p.getNombre() + " | Vida: " + p.getVida() +
                    " | Ataque: " + p.getAtaque() +
                    " | Defensa: " + p.getDefensa() +
                    " | Alcance: " + p.getAlcance() +
                    " | Nivel: " + p.getNivel());
        }
    }

    public void filtrarPorAtributo(String atributo) {
        List<Personaje> ordenados;
        switch (atributo.toLowerCase()) {
            case "vida":
                ordenados = personajes.stream().sorted(Comparator.comparingInt(Personaje::getVida).reversed()).collect(Collectors.toList());
                break;
            case "ataque":
                ordenados = personajes.stream().sorted(Comparator.comparingInt(Personaje::getAtaque).reversed()).collect(Collectors.toList());
                break;
            case "defensa":
                ordenados = personajes.stream().sorted(Comparator.comparingInt(Personaje::getDefensa).reversed()).collect(Collectors.toList());
                break;
            case "alcance":
                ordenados = personajes.stream().sorted(Comparator.comparingInt(Personaje::getAlcance).reversed()).collect(Collectors.toList());
                break;
            default:
                System.out.println("Atributo inválido.");
                return;
        }
        System.out.println("\nPersonajes ordenados por " + atributo + ":");
        for (Personaje p : ordenados) {
            System.out.println(p.getNombre() + " - " + atributo + ": " + obtenerValor(p, atributo));
        }
    }

    private int obtenerValor(Personaje p, String atributo) {
        switch (atributo.toLowerCase()) {
            case "vida": return p.getVida();
            case "ataque": return p.getAtaque();
            case "defensa": return p.getDefensa();
            case "alcance": return p.getAlcance();
            default: return 0;
        }
    }

    public void actualizarAtributo(String nombre, String atributo, int nuevoValor) {
        for (Personaje p : personajes) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                switch (atributo.toLowerCase()) {
                    case "vida": p.setVida(nuevoValor); break;
                    case "ataque": p.setAtaque(nuevoValor); break;
                    case "defensa": p.setDefensa(nuevoValor); break;
                    case "alcance": p.setAlcance(nuevoValor); break;
                    default: System.out.println("Atributo no válido."); return;
                }
                guardarEnArchivo();
                System.out.println("Atributo actualizado correctamente.");
                return;
            }
        }
        System.out.println("Personaje no encontrado.");
    }

    public void mostrarEstadisticas() {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes para calcular estadísticas.");
            return;
        }
        double promVida = personajes.stream().mapToInt(Personaje::getVida).average().orElse(0);
        double promAtaque = personajes.stream().mapToInt(Personaje::getAtaque).average().orElse(0);
        double promDefensa = personajes.stream().mapToInt(Personaje::getDefensa).average().orElse(0);
        double promAlcance = personajes.stream().mapToInt(Personaje::getAlcance).average().orElse(0);
        System.out.println("\nEstadísticas Generales:");
        System.out.println("Total de personajes: " + personajes.size());
        System.out.printf("Vida promedio: %.2f | Ataque promedio: %.2f | Defensa promedio: %.2f | Alcance promedio: %.2f%n",
                promVida, promAtaque, promDefensa, promAlcance);
    }

    public void importarDesdeArchivo(String ruta) {
        File file = new File(ruta);
        if (!file.exists()) {
            System.out.println("El archivo no existe.");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Personaje p = Personaje.fromString(linea);
                if (p != null) agregarPersonaje(p);
            }
            System.out.println("Personajes importados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al importar: " + e.getMessage());
        }
    }

    private void cargarPersonajesAleatorios() {
        if (personajes.isEmpty()) {
            for (int i = 0; i < 3; i++) {
                agregarPersonaje(Personaje.generarAleatorio());
            }
        }
    }

    public void subirNivel(String nombre) {
        for (Personaje p : personajes) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                p.subirNivel();
                guardarEnArchivo();
                System.out.println(nombre + " ha subido al nivel " + p.getNivel());
                return;
            }
        }
        System.out.println("Personaje no encontrado.");
    }
}
