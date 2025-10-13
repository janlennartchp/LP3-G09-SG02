import java.io.*;

public class Actividad3 {
    public static void main(String[] args) {
        int lineas = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("salida.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                lineas++;
            }
            System.out.println("Total de líneas: " + lineas);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

