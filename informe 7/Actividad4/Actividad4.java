import java.io.*;

public class Actividad4 {
    public static void main(String[] args) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("datos.dat"))) {
            dos.writeInt(123);
            dos.writeDouble(45.67);
            dos.writeBoolean(true);
            dos.writeUTF("Hola binario");
        } catch (IOException e) {
            System.out.println("Error al escribir binario: " + e.getMessage());
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream("datos.dat"))) {
            System.out.println("Entero: " + dis.readInt());
            System.out.println("Double: " + dis.readDouble());
            System.out.println("Boolean: " + dis.readBoolean());
            System.out.println("Texto: " + dis.readUTF());
        } catch (IOException e) {
            System.out.println("Error al leer binario: " + e.getMessage());
        }
    }
}
