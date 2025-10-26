package com.proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase para gestionar la conexión a la base de datos SQLite
 */
public class DatabaseConnection {
    private static final String DB_URL = "jdbc:sqlite:estudiantes.db";
    private static final String CLAVE_CORRECTA = "admin123";

    // Bloque estático para cargar el driver JDBC de SQLite
    static {
        try {
            Class.forName("org.sqlite.JDBC");
            System.out.println("Driver SQLite cargado correctamente.");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se pudo cargar el driver SQLite.");
            System.err.println("Asegúrese de que sqlite-jdbc-3.45.0.0.jar está en el classpath.");
            e.printStackTrace();
        }
    }

    /**
     * Obtiene una conexión a la base de datos
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    /**
     * Inicializa la base de datos y crea la tabla si no existe
     */
    public static void inicializarBaseDatos() {
        String sql = "CREATE TABLE IF NOT EXISTS estudiantes (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     "nombre TEXT NOT NULL, " +
                     "edad INTEGER NOT NULL, " +
                     "carrera TEXT NOT NULL, " +
                     "promedio REAL NOT NULL)";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Base de datos inicializada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al inicializar la base de datos: " + e.getMessage());
        }
    }

    /**
     * Valida si la clave ingresada es correcta
     */
    public static boolean validarClave(String clave) {
        return CLAVE_CORRECTA.equals(clave);
    }

    /**
     * Obtiene la clave correcta (solo para fines de demostración)
     */
    public static String getClaveCorrecta() {
        return CLAVE_CORRECTA;
    }
}
