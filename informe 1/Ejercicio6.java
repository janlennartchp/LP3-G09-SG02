import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese las horas: ");
        int horas = sc.nextInt();

        System.out.print("Ingrese los minutos: ");
        int minutos = sc.nextInt();

        System.out.print("Ingrese los segundos: ");
        int segundos = sc.nextInt();

        int totalSegundos = (horas * 3600) + (minutos * 60) + segundos;

        System.out.println("✅ Equivalente en segundos: " + totalSegundos);

        sc.close();
    }
}
