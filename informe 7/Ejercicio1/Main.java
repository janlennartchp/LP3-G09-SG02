import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gestor gestor = new Gestor();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== GESTOR DE PERSONAJES ===");
            System.out.println("1. Agregar personaje");
            System.out.println("2. Mostrar personajes");
            System.out.println("3. Modificar personaje");
            System.out.println("4. Eliminar personaje");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Vida: ");
                    int vida = sc.nextInt();
                    System.out.print("Ataque: ");
                    int ataque = sc.nextInt();
                    System.out.print("Defensa: ");
                    int defensa = sc.nextInt();
                    System.out.print("Alcance: ");
                    int alcance = sc.nextInt();
                    gestor.agregarPersonaje(new Personaje(nombre, vida, ataque, defensa, alcance));
                    break;

                case 2:
                    gestor.mostrarPersonajes();
                    break;

                case 3:
                    System.out.print("Ingrese el nombre del personaje a modificar: ");
                    String nombreMod = sc.nextLine();
                    System.out.print("Nueva vida: ");
                    int vidaMod = sc.nextInt();
                    System.out.print("Nuevo ataque: ");
                    int ataqueMod = sc.nextInt();
                    System.out.print("Nueva defensa: ");
                    int defensaMod = sc.nextInt();
                    System.out.print("Nuevo alcance: ");
                    int alcanceMod = sc.nextInt();
                    gestor.modificarPersonaje(nombreMod, vidaMod, ataqueMod, defensaMod, alcanceMod);
                    break;

                case 4:
                    System.out.print("Ingrese el nombre del personaje a eliminar: ");
                    String nombreDel = sc.nextLine();
                    gestor.eliminarPersonaje(nombreDel);
                    break;

                case 5:
                    System.out.println(" Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        sc.close();
    }
}

