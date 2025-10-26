# Práctica JDBC con SQLite

## Contexto del problema
Desarrollar una aplicación Java de consola que se conecte a una base de datos **SQLite** mediante **JDBC**,  
permitiendo realizar operaciones básicas de inserción, actualización, eliminación y consulta de registros,  
empleando **PreparedStatement** y **manejo de transacciones**.

---

## Experiencia de práctica
La base de datos contiene una tabla llamada `empleados` con los siguientes campos:

| Campo | Tipo | Descripción |
|--------|------|-------------|
| id | INTEGER | Identificador autoincremental |
| nombre | TEXT | Nombre del empleado |
| edad | INTEGER | Edad del empleado |

La aplicación incluye:
- **Insertar:** Añadir nuevos registros.
- **Mostrar:** Consultar los registros almacenados.
- **Actualizar:** Modificar registros existentes.
- **Borrar:** Eliminar registros.
- **Clave de seguridad:** Verificación antes de confirmar cambios (`1234`).

Cada operación de modificación (insertar, actualizar, eliminar) utiliza **transacciones**:
```java
con.setAutoCommit(false);
con.commit();
con.rollback();
