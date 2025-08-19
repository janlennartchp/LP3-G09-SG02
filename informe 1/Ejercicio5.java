import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el número de horas: ");
        int horas = sc.nextInt();

        double total;

        if (horas <= 1) {
            total = 3.0;
        } else {
            total = 3.0 + (horas - 1) * 0.5;
        }
        
        if (total > 12.0) {
            total = 12.0;
        }

        System.out.println("✅ El cargo total es: S/" + total);

        sc.close();
    }
}
