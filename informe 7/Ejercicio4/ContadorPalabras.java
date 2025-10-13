package Ejercicio4;

import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;

public class ContadorPalabras {

    public static void main(String[] args) {
        File archivo = seleccionarArchivo();
        if (archivo == null) {
            System.out.println("No se seleccionó ningún archivo. Saliendo...");
            return;
        }

        procesarArchivo(archivo);
    }

    // Permite al usuario elegir un archivo
    private static File seleccionarArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccione un archivo de texto (.txt)");
        int resultado = fileChooser.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            if (archivo.exists() && archivo.isFile()) {
                return archivo;
            } else {
                System.out.println("Archivo inválido o no encontrado.");
                return seleccionarArchivo(); // volver a intentar
            }
        }
        return null;
    }

    // Procesa el archivo y muestra los resultados
    private static void procesarArchivo(File archivo) {
        int totalLineas = 0;
        int totalPalabras = 0;
        int totalCaracteres = 0;
        Map<String, Integer> frecuenciaPalabras = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                totalLineas++;
                totalCaracteres += contarCaracteres(linea);

                List<String> palabras = extraerPalabras(linea);
                totalPalabras += palabras.size();

                for (String palabra : palabras) {
                    palabra = palabra.toLowerCase();
                    frecuenciaPalabras.put(palabra, frecuenciaPalabras.getOrDefault(palabra, 0) + 1);
                }
            }

            mostrarResultados(totalLineas, totalPalabras, totalCaracteres, frecuenciaPalabras);

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Cuenta los caracteres válidos (sin contar saltos de línea)
    private static int contarCaracteres(String linea) {
        int contador = 0;
        for (char c : linea.toCharArray()) {
            if (c != '\n' && c != '\r') {
                contador++;
            }
        }
        return contador;
    }

    // Extrae palabras válidas de una línea
    private static List<String> extraerPalabras(String linea) {
        List<String> palabras = new ArrayList<>();
        StringBuilder palabraActual = new StringBuilder();

        for (char c : linea.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                palabraActual.append(c);
            } else {
                if (palabraActual.length() > 0) {
                    palabras.add(palabraActual.toString());
                    palabraActual.setLength(0);
                }
            }
        }
        if (palabraActual.length() > 0) {
            palabras.add(palabraActual.toString());
        }

        return palabras;
    }

    // Muestra los resultados en consola
    private static void mostrarResultados(int lineas, int palabras, int caracteres, Map<String, Integer> frecuencia) {
        System.out.println("===== RESULTADOS =====");
        System.out.println("Total de líneas: " + lineas);
        System.out.println("Total de palabras: " + palabras);
        System.out.println("Total de caracteres (sin saltos de línea): " + caracteres);
        System.out.printf("Promedio de palabras por línea: %.2f%n", (lineas > 0 ? (double) palabras / lineas : 0));

        System.out.println("\nPalabras más frecuentes:");
        frecuencia.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder()))
            .limit(10)
            .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}

