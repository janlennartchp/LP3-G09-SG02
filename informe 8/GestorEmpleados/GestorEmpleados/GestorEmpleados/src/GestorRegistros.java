import java.sql.*;
import java.util.*;

public class GestorRegistros {
    private static final String DB_URL = "jdbc:sqlite:empleados.db";
    private Connection connection;

    public GestorRegistros() {
        try {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException e) {
                System.err.println("ERROR: No se pudo cargar el driver SQLite.");
                System.err.println("Asegúrate de que sqlite-jdbc-3.45.1.0.jar esté en el classpath.");
                throw new SQLException("Driver SQLite no encontrado", e);
            }

            connection = DriverManager.getConnection(DB_URL);
            crearTabla();
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void crearTabla() {
        String sql = "CREATE TABLE IF NOT EXISTS empleados (" +
                     "id INTEGER PRIMARY KEY," +
                     "nombre TEXT NOT NULL," +
                     "edad INTEGER NOT NULL," +
                     "sueldo REAL NOT NULL)";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Error al crear tabla: " + e.getMessage());
        }
    }

    public void agregarEmpleado(Empleado e) {
        String sql = "INSERT OR REPLACE INTO empleados(id, nombre, edad, sueldo) VALUES(?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, e.getId());
            pstmt.setString(2, e.getNombre());
            pstmt.setInt(3, e.getEdad());
            pstmt.setDouble(4, e.getSueldo());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al agregar empleado: " + ex.getMessage());
        }
    }

    public void consultar(List<String> camposAMostrar, String condicion, String ordenarPor, boolean ascendente, int limite) {
        StringBuilder sql = new StringBuilder("SELECT * FROM empleados");

        if (condicion != null && !condicion.isEmpty()) {
            String whereClause = procesarCondicion(condicion);
            if (whereClause != null) {
                sql.append(" WHERE ").append(whereClause);
            }
        }

        if (ordenarPor != null && !ordenarPor.isEmpty()) {
            sql.append(" ORDER BY ").append(ordenarPor);
            sql.append(ascendente ? " ASC" : " DESC");
        }

        if (limite > 0) {
            sql.append(" LIMIT ").append(limite);
        }

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql.toString())) {

            while (rs.next()) {
                Empleado emp = new Empleado(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("edad"),
                    rs.getDouble("sueldo")
                );
                mostrarCampos(emp, camposAMostrar);
            }
        } catch (SQLException e) {
            System.out.println("Error en consulta: " + e.getMessage());
        }
    }

    private String procesarCondicion(String condicion) {
        condicion = condicion.replaceAll("\\s+", "");

        try {
            if (condicion.contains(">")) {
                String[] parts = condicion.split(">");
                return parts[0] + " > " + parts[1];
            } else if (condicion.contains("<")) {
                String[] parts = condicion.split("<");
                return parts[0] + " < " + parts[1];
            } else if (condicion.contains("=")) {
                String[] parts = condicion.split("=");
                return parts[0] + " = " + parts[1];
            }
        } catch (Exception e) {
            System.out.println("Condición inválida.");
        }
        return null;
    }

    private void mostrarCampos(Empleado e, List<String> campos) {
        if (campos == null || campos.isEmpty() || campos.get(0).trim().isEmpty()) {
            System.out.println(e);
            return;
        }

        StringBuilder sb = new StringBuilder("{ ");
        for (String c : campos) {
            c = c.trim();
            switch (c) {
                case "id" -> sb.append("id=").append(e.getId()).append(" ");
                case "nombre" -> sb.append("nombre=").append(e.getNombre()).append(" ");
                case "edad" -> sb.append("edad=").append(e.getEdad()).append(" ");
                case "sueldo" -> sb.append("sueldo=").append(e.getSueldo()).append(" ");
            }
        }
        sb.append("}");
        System.out.println(sb);
    }

    public void limpiarTabla() {
        String sql = "DELETE FROM empleados";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Error al limpiar tabla: " + e.getMessage());
        }
    }

    public void cerrarConexion() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar conexión: " + e.getMessage());
        }
    }
}
