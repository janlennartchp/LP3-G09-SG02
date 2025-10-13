import java.nio.file.*;
import java.io.IOException;
import java.util.List;

public class Actividad6 {
    public static void main(String[] args) {
        Path archivo = Paths.get("nio.txt");

        try {
            Files.writeString(archivo, "Ejemplo usando NIO.\nNueva línea de texto.");
            List<String> lineas = Files.readAllLines(archivo);
            System.out.println("Contenido del archivo:");
            for (String l : lineas) System.out.println(l);

            Path copia = Paths.get("nio_copia.txt");
            Files.copy(archivo, copia, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Archivo copiado correctamente.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

