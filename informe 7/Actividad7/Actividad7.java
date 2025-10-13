import javax.swing.*;
import java.io.*;

public class Actividad7 {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        int opcion = chooser.showOpenDialog(null);

        if (opcion == JFileChooser.APPROVE_OPTION) {
            File archivo = chooser.getSelectedFile();
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                System.out.println("Contenido del archivo seleccionado:\n");
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
            } catch (IOException e) {
                System.out.println("Error al leer: " + e.getMessage());
            }
        } else {
            System.out.println("No se seleccionó ningún archivo.");
        }
    }
}

