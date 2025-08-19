import java.util.Scanner;
public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[100]; 
        int contador = 0;
        System.out.print("Ingrese el primer número (o '.' para terminar): ");
        String entrada = sc.next();
        if (entrada.equals(".")) {
            System.out.println("No se ingresaron números.");
            sc.close();
            return;
        }
        numeros[contador] = Integer.parseInt(entrada);
        contador++;
        while (true) {
            System.out.print("Ingrese un número mayor que " + numeros[contador - 1] + " (o '.' para terminar): ");
            entrada = sc.next();
            if (entrada.equals(".")) {
                break; 
            }
            int siguiente = Integer.parseInt(entrada);
            if (siguiente > numeros[contador - 1]) {
                numeros[contador] = siguiente;
                contador++;
            } else {
                System.out.println("❌ El número debe ser mayor. Intente de nuevo.");
            }
        }
        System.out.println("\n✅ Arreglo ingresado:");
        for (int i = 0; i < contador; i++) {
            System.out.print(numeros[i] + " ");
        }
        sc.close();
    }
}