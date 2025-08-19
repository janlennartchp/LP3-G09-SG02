import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el tamaño del arreglo: ");
        int n = sc.nextInt();
        int[] numeros = new int[n];
        int suma = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese un número: ");
            numeros[i] = sc.nextInt();
            suma += numeros[i];
        }
        System.out.println("\n✅ La suma de los elementos es: " + suma);

        sc.close();
    }
}