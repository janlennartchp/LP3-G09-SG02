package com.proyecto;

import java.util.Scanner;

/**
 * Clase principal con el menú interactivo
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  SISTEMA DE GESTIÓN DE ESTUDIANTES");
        System.out.println("========================================");
        System.out.println("Inicializando base de datos...\n");

        // Inicializar la base de datos
        DatabaseConnection.inicializarBaseDatos();

        System.out.println("\nClave de administrador: " + DatabaseConnection.getClaveCorrecta());
        System.out.println("(Esta clave es requerida para operaciones de modificación)\n");

        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    insertarEstudiante();
                    break;
                case 2:
                    actualizarEstudiante();
                    break;
                case 3:
                    borrarEstudiante();
                    break;
                case 4:
                    EstudianteDAO.mostrarTodos();
                    break;
                case 5:
                    System.out.println("\n¡Gracias por usar el sistema! Hasta luego.\n");
                    continuar = false;
                    break;
                default:
                    System.out.println("\n*** Opción inválida. Intente nuevamente. ***\n");
            }
        }

        scanner.close();
    }

    /**
     * Muestra el menú principal
     */
    private static void mostrarMenu() {
        System.out.println("========================================");
        System.out.println("           MENÚ PRINCIPAL");
        System.out.println("========================================");
        System.out.println("1. Insertar nuevo estudiante");
        System.out.println("2. Actualizar estudiante");
        System.out.println("3. Eliminar estudiante");
        System.out.println("4. Mostrar todos los estudiantes");
        System.out.println("5. Salir");
        System.out.println("========================================");
        System.out.print("Seleccione una opción: ");
    }

    /**
     * Lee una opción del menú
     */
    private static int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Maneja la inserción de un nuevo estudiante
     */
    private static void insertarEstudiante() {
        System.out.println("\n========================================");
        System.out.println("      INSERTAR NUEVO ESTUDIANTE");
        System.out.println("========================================");

        try {
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Edad: ");
            int edad = Integer.parseInt(scanner.nextLine());

            System.out.print("Carrera: ");
            String carrera = scanner.nextLine();

            System.out.print("Promedio: ");
            double promedio = Double.parseDouble(scanner.nextLine());

            System.out.print("\nIngrese la clave de administrador: ");
            String clave = scanner.nextLine();

            EstudianteDAO.insertar(nombre, edad, carrera, promedio, clave);

        } catch (NumberFormatException e) {
            System.out.println("\n*** Error: Formato de número inválido. ***\n");
        }
    }

    /**
     * Maneja la actualización de un estudiante
     */
    private static void actualizarEstudiante() {
        System.out.println("\n========================================");
        System.out.println("       ACTUALIZAR ESTUDIANTE");
        System.out.println("========================================");

        // Primero mostrar los estudiantes existentes
        EstudianteDAO.mostrarTodos();

        try {
            System.out.print("ID del estudiante a actualizar: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Nuevo nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Nueva edad: ");
            int edad = Integer.parseInt(scanner.nextLine());

            System.out.print("Nueva carrera: ");
            String carrera = scanner.nextLine();

            System.out.print("Nuevo promedio: ");
            double promedio = Double.parseDouble(scanner.nextLine());

            System.out.print("\nIngrese la clave de administrador: ");
            String clave = scanner.nextLine();

            EstudianteDAO.actualizar(id, nombre, edad, carrera, promedio, clave);

        } catch (NumberFormatException e) {
            System.out.println("\n*** Error: Formato de número inválido. ***\n");
        }
    }

    /**
     * Maneja la eliminación de un estudiante
     */
    private static void borrarEstudiante() {
        System.out.println("\n========================================");
        System.out.println("        ELIMINAR ESTUDIANTE");
        System.out.println("========================================");

        // Primero mostrar los estudiantes existentes
        EstudianteDAO.mostrarTodos();

        try {
            System.out.print("ID del estudiante a eliminar: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("\n¿Está seguro de eliminar este estudiante? (S/N): ");
            String confirmacion = scanner.nextLine();

            if (confirmacion.equalsIgnoreCase("S")) {
                System.out.print("\nIngrese la clave de administrador: ");
                String clave = scanner.nextLine();

                EstudianteDAO.borrar(id, clave);
            } else {
                System.out.println("\n*** Operación cancelada. ***\n");
            }

        } catch (NumberFormatException e) {
            System.out.println("\n*** Error: Formato de número inválido. ***\n");
        }
    }
}
