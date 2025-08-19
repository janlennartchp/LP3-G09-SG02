import java.util.Random;
public class Ejercicio3 {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] frecuencia = new int[6];
        for (int i = 0; i < 20000; i++) {
            int cara = rand.nextInt(6); // devuelve 0 a 5
            frecuencia[cara]++;   
        }

        System.out.println("✅ Frecuencia de cada cara:");
        for (int i = 0; i < 6; i++) {
            System.out.println("Cara " + (i + 1) + ": " + frecuencia[i]);
        }
    }
}