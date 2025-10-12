import java.io.*;
public class Actividad5 {
    public static void main(String[] args) {
        Persona p1 = new Persona("Carlos", 25);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("persona.obj"))) {
            oos.writeObject(p1);
            System.out.println("Objeto serializado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al serializar: " + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("persona.obj"))) {
            Persona p = (Persona) ois.readObject();
            System.out.println("Objeto leído: " + p);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al deserializar: " + e.getMessage());
        }
    }
}