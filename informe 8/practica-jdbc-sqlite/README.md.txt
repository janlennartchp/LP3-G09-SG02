# Pr�ctica JDBC con SQLite

## Contexto del problema
Desarrollar una aplicaci�n Java de consola que se conecte a una base de datos **SQLite** mediante **JDBC**,  
permitiendo realizar operaciones b�sicas de inserci�n, actualizaci�n, eliminaci�n y consulta de registros,  
empleando **PreparedStatement** y **manejo de transacciones**.

---

## Experiencia de pr�ctica
La base de datos contiene una tabla llamada `empleados` con los siguientes campos:

| Campo | Tipo | Descripci�n |
|--------|------|-------------|
| id | INTEGER | Identificador autoincremental |
| nombre | TEXT | Nombre del empleado |
| edad | INTEGER | Edad del empleado |

La aplicaci�n incluye:
- **Insertar:** A�adir nuevos registros.
- **Mostrar:** Consultar los registros almacenados.
- **Actualizar:** Modificar registros existentes.
- **Borrar:** Eliminar registros.
- **Clave de seguridad:** Verificaci�n antes de confirmar cambios (`1234`).

Cada operaci�n de modificaci�n (insertar, actualizar, eliminar) utiliza **transacciones**:
```java
con.setAutoCommit(false);
con.commit();
con.rollback();
