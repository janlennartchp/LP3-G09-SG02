import java.io.*;

public class Actividad2 {
    public static void main(String[] args) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("salida.txt", true))) {
            bw.write("Java permite escribir archivos fácilmente.\n");
            bw.write("Esta es otra línea agregada al final.\n");
            System.out.println("Archivo escrito correctamente.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

