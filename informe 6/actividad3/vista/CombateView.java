package vista;

import modelo.Enemigo;
import modelo.Jugador;
import java.util.Scanner;

public class CombateView {
    private Scanner scanner;

    public CombateView() {
        scanner = new Scanner(System.in);
    }

    public void mostrarEstadoCombate(Jugador jugador, Enemigo enemigo) {
        System.out.println("\n===== ESTADO DEL COMBATE =====");
        System.out.println("👨 Jugador: " + jugador.getNombre() + " | Salud: " + jugador.getSalud() + " | Nivel: " + jugador.getNivel());
        System.out.println("👹 Enemigo: " + enemigo.getNombre() + " | Salud: " + enemigo.getSalud() + " | Nivel: " + enemigo.getNivel());
        System.out.println("==============================");
    }

    public String mostrarMenuCombate() {
        System.out.println("\n1. Atacar");
        System.out.println("2. Usar objeto");
        System.out.println("3. Equipar arma");
        System.out.println("4. Huir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextLine();
    }

    public String solicitarTexto(String mensaje) {
        System.out.print(mensaje + ": ");
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
