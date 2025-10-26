package app; // si tu paquete tiene otro nombre, cámbialo

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class GestorSQLite {
    private static final String DB_URL = "jdbc:sqlite:basedatos.db";
    private static final String CLAVE_SEGURIDAD = "1234"; // clave para confirmar cambios

    public static void main(String[] args) {
        try {
            // Cargar el driver de SQLite
            Class.forName("org.sqlite.JDBC");

            // Conectarse a la base de datos (se crea si no existe)
            Connection con = DriverManager.getConnection(DB_URL);
            crearTabla(con);

            Scanner sc = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("\n=== MENÚ PRINCIPAL ===");
                System.out.println("1. Insertar registro");
                System.out.println("2. Mostrar registros");
                System.out.println("3. Actualizar registro");
                System.out.println("4. Borrar registro");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1 -> insertar(con, sc);
                    case 2 -> mostrar(con);
                    case 3 -> actualizar(con, sc);
                    case 4 -> borrar(con, sc);
                    case 0 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción inválida.");
                }
            } while (opcion != 0);

            sc.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Crear tabla si no existe
    private static void crearTabla(Connection con) throws SQLException {
        String sql = """
            CREATE TABLE IF NOT EXISTS empleados (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nombre TEXT NOT NULL,
                edad INTEGER
            );
            """;
        try (Statement stmt = con.createStatement()) {
            stmt.execute(sql);
        }
    }

    // Insertar registro
    private static void insertar(Connection con, Scanner sc) throws SQLException {
        sc.nextLine();
        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese edad: ");
        int edad = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese clave de seguridad: ");
        String clave = sc.nextLine();

        con.setAutoCommit(false);

        if (clave.equals(CLAVE_SEGURIDAD)) {
            String sql = "INSERT INTO empleados(nombre, edad) VALUES(?, ?)";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, nombre);
                ps.setInt(2, edad);
                ps.executeUpdate();
                con.commit();
                System.out.println(" Registro insertado correctamente.");
            }
        } else {
            con.rollback();
            System.out.println(" Clave incorrecta. Operación cancelada.");
        }

        con.setAutoCommit(true);
    }

    // Mostrar registros
    private static void mostrar(Connection con) throws SQLException {
        String sql = "SELECT * FROM empleados";
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- LISTA DE EMPLEADOS ---");
            while (rs.next()) {
                System.out.printf("ID: %d | Nombre: %s | Edad: %d%n",
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("edad"));
            }
        }
    }

    // Actualizar registro
    private static void actualizar(Connection con, Scanner sc) throws SQLException {
        mostrar(con);
        System.out.print("Ingrese ID del registro a actualizar: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Nuevo nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Nueva edad: ");
        int edad = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese clave de seguridad: ");
        String clave = sc.nextLine();

        con.setAutoCommit(false);
        if (clave.equals(CLAVE_SEGURIDAD)) {
            String sql = "UPDATE empleados SET nombre=?, edad=? WHERE id=?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, nombre);
                ps.setInt(2, edad);
                ps.setInt(3, id);
                ps.executeUpdate();
                con.commit();
                System.out.println(" Registro actualizado correctamente.");
            }
        } else {
            con.rollback();
            System.out.println(" Clave incorrecta. Operación cancelada.");
        }

        con.setAutoCommit(true);
    }

    // Borrar registro
    private static void borrar(Connection con, Scanner sc) throws SQLException {
        mostrar(con);
        System.out.print("Ingrese ID del registro a borrar: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese clave de seguridad: ");
        String clave = sc.nextLine();

        con.setAutoCommit(false);
        if (clave.equals(CLAVE_SEGURIDAD)) {
            String sql = "DELETE FROM empleados WHERE id=?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, id);
                ps.executeUpdate();
                con.commit();
                System.out.println(" Registro eliminado correctamente.");
            }
        } else {
            con.rollback();
            System.out.println(" Clave incorrecta. Operación cancelada.");
        }

        con.setAutoCommit(true);
    }
}
