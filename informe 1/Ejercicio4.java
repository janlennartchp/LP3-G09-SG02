import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Ingrese el primer número: ");
        double n1 = sc.nextDouble();

        System.out.print("Ingrese el segundo número: ");
        double n2 = sc.nextDouble();

        System.out.print("Ingrese el tercer número: ");
        double n3 = sc.nextDouble();

        double menor = n1;
        if (n2 < menor) {
            menor = n2;
        }
        if (n3 < menor) {
            menor = n3;
        }

        System.out.println("✅ El menor de los tres números es: " + menor);

        sc.close();
    }
}