package com.proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

/**
 * Clase para gestionar las operaciones CRUD de la tabla estudiantes
 */
public class EstudianteDAO {

    /**
     * Inserta un nuevo estudiante en la base de datos
     */
    public static boolean insertar(String nombre, int edad, String carrera, double promedio, String clave) {
        if (!DatabaseConnection.validarClave(clave)) {
            System.out.println("\n*** ERROR: Clave incorrecta. Operación cancelada. ***\n");
            return false;
        }

        String sql = "INSERT INTO estudiantes(nombre, edad, carrera, promedio) VALUES(?, ?, ?, ?)";
        Connection conn = null;
        Savepoint savepoint = null;

        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false);
            savepoint = conn.setSavepoint("InsertSavepoint");

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, nombre);
                pstmt.setInt(2, edad);
                pstmt.setString(3, carrera);
                pstmt.setDouble(4, promedio);
                pstmt.executeUpdate();

                conn.commit();
                System.out.println("\n*** Estudiante insertado correctamente. ***\n");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("\n*** Error al insertar estudiante: " + e.getMessage() + " ***");
            try {
                if (conn != null && savepoint != null) {
                    conn.rollback(savepoint);
                    System.out.println("*** Cambios revertidos. ***\n");
                }
            } catch (SQLException ex) {
                System.out.println("Error al revertir cambios: " + ex.getMessage());
            }
            return false;
        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    /**
     * Actualiza un estudiante existente
     */
    public static boolean actualizar(int id, String nombre, int edad, String carrera, double promedio, String clave) {
        if (!DatabaseConnection.validarClave(clave)) {
            System.out.println("\n*** ERROR: Clave incorrecta. Operación cancelada. ***\n");
            return false;
        }

        String sql = "UPDATE estudiantes SET nombre = ?, edad = ?, carrera = ?, promedio = ? WHERE id = ?";
        Connection conn = null;
        Savepoint savepoint = null;

        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false);
            savepoint = conn.setSavepoint("UpdateSavepoint");

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, nombre);
                pstmt.setInt(2, edad);
                pstmt.setString(3, carrera);
                pstmt.setDouble(4, promedio);
                pstmt.setInt(5, id);

                int filasAfectadas = pstmt.executeUpdate();

                if (filasAfectadas > 0) {
                    conn.commit();
                    System.out.println("\n*** Estudiante actualizado correctamente. ***\n");
                    return true;
                } else {
                    conn.rollback(savepoint);
                    System.out.println("\n*** No se encontró un estudiante con ID: " + id + " ***\n");
                    return false;
                }
            }
        } catch (SQLException e) {
            System.out.println("\n*** Error al actualizar estudiante: " + e.getMessage() + " ***");
            try {
                if (conn != null && savepoint != null) {
                    conn.rollback(savepoint);
                    System.out.println("*** Cambios revertidos. ***\n");
                }
            } catch (SQLException ex) {
                System.out.println("Error al revertir cambios: " + ex.getMessage());
            }
            return false;
        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    /**
     * Elimina un estudiante por su ID
     */
    public static boolean borrar(int id, String clave) {
        if (!DatabaseConnection.validarClave(clave)) {
            System.out.println("\n*** ERROR: Clave incorrecta. Operación cancelada. ***\n");
            return false;
        }

        String sql = "DELETE FROM estudiantes WHERE id = ?";
        Connection conn = null;
        Savepoint savepoint = null;

        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false);
            savepoint = conn.setSavepoint("DeleteSavepoint");

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                int filasAfectadas = pstmt.executeUpdate();

                if (filasAfectadas > 0) {
                    conn.commit();
                    System.out.println("\n*** Estudiante eliminado correctamente. ***\n");
                    return true;
                } else {
                    conn.rollback(savepoint);
                    System.out.println("\n*** No se encontró un estudiante con ID: " + id + " ***\n");
                    return false;
                }
            }
        } catch (SQLException e) {
            System.out.println("\n*** Error al eliminar estudiante: " + e.getMessage() + " ***");
            try {
                if (conn != null && savepoint != null) {
                    conn.rollback(savepoint);
                    System.out.println("*** Cambios revertidos. ***\n");
                }
            } catch (SQLException ex) {
                System.out.println("Error al revertir cambios: " + ex.getMessage());
            }
            return false;
        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    /**
     * Muestra todos los estudiantes
     */
    public static void mostrarTodos() {
        String sql = "SELECT * FROM estudiantes ORDER BY id";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("\n========================================");
            System.out.println("         LISTA DE ESTUDIANTES");
            System.out.println("========================================");

            boolean hayRegistros = false;
            while (rs.next()) {
                hayRegistros = true;
                System.out.println("\nID:       " + rs.getInt("id"));
                System.out.println("Nombre:   " + rs.getString("nombre"));
                System.out.println("Edad:     " + rs.getInt("edad"));
                System.out.println("Carrera:  " + rs.getString("carrera"));
                System.out.println("Promedio: " + rs.getDouble("promedio"));
                System.out.println("----------------------------------------");
            }

            if (!hayRegistros) {
                System.out.println("\nNo hay estudiantes registrados.");
                System.out.println("----------------------------------------");
            }
            System.out.println();

        } catch (SQLException e) {
            System.out.println("\n*** Error al mostrar estudiantes: " + e.getMessage() + " ***\n");
        }
    }
}
