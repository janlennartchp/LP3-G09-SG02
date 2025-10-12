import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gestor gestor = new Gestor();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== GESTOR DE PERSONAJES AVANZADO ===");
            System.out.println("1. Mostrar personajes");
            System.out.println("2. Filtrar por atributo");
            System.out.println("3. Actualizar atributo individual");
            System.out.println("4. Mostrar estadísticas");
            System.out.println("5. Importar personajes desde archivo");
            System.out.println("6. Subir nivel de un personaje");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    gestor.mostrarPersonajes();
                    break;
                case 2:
                    System.out.print("Atributo (vida/ataque/defensa/alcance): ");
                    String atributo = sc.nextLine();
                    gestor.filtrarPorAtributo(atributo);
                    break;
                case 3:
                    System.out.print("Nombre del personaje: ");
                    String nombre = sc.nextLine();
                    System.out.print("Atributo a modificar: ");
                    String atr = sc.nextLine();
                    System.out.print("Nuevo valor: ");
                    int valor = sc.nextInt();
                    gestor.actualizarAtributo(nombre, atr, valor);
                    break;
                case 4:
                    gestor.mostrarEstadisticas();
                    break;
                case 5:
                    System.out.print("Ruta del archivo a importar: ");
                    String ruta = sc.nextLine();
                    gestor.importarDesdeArchivo(ruta);
                    break;
                case 6:
                    System.out.print("Nombre del personaje: ");
                    String nom = sc.nextLine();
                    gestor.subirNivel(nom);
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 7);
        sc.close();
    }
}
