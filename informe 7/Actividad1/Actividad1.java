import java.io.*;

public class Actividad1 {
    public static void main(String[] args) {
        String nombreArchivo = "datos.txt";

        try (FileWriter fw = new FileWriter(nombreArchivo);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("Primera línea del archivo.\n");
            bw.write("Segunda línea escrita desde Java.\n");
            bw.write("Tercera línea final.");
        } catch (IOException e) {
            System.out.println("Error al escribir: " + e.getMessage());
        }

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            System.out.println("Contenido del archivo:");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }
    }
}

