# Gestor de Empleados con SQLite

Proyecto Java para Eclipse que permite gestionar empleados usando una base de datos SQLite.

## Estructura del Proyecto

```
GestorEmpleados/
├── src/
│   ├── Main.java
│   ├── Empleado.java
│   └── GestorRegistros.java
├── lib/
│   └── sqlite-jdbc-3.45.1.0.jar
├── .project
├── .classpath
└── README.md
```

## Características

- Almacenamiento persistente de empleados en SQLite
- Consultas con filtros personalizables
- Ordenamiento por diferentes campos
- Selección de campos específicos para mostrar
- Límite de resultados

## Cómo Importar en Eclipse

1. Abre Eclipse IDE
2. Ve a **File > Import**
3. Selecciona **General > Existing Projects into Workspace**
4. Haz clic en **Next**
5. En "Select root directory", haz clic en **Browse** y selecciona la carpeta `GestorEmpleados`
6. Asegúrate de que el proyecto esté seleccionado en la lista
7. Haz clic en **Finish**

## Cómo Ejecutar

1. En Eclipse, navega a `src/Main.java`
2. Haz clic derecho en el archivo
3. Selecciona **Run As > Java Application**
4. Sigue las instrucciones en consola

## Ejemplos de Uso

### Mostrar campos específicos:
```
nombre,sueldo
```

### Aplicar condiciones:
```
sueldo>1200
edad<30
```

### Ordenar:
```
Campo: sueldo
Ascendente: true
```

### Limitar resultados:
```
Límite: 2
```

## Base de Datos

El archivo de base de datos `empleados.db` se creará automáticamente en el directorio del proyecto la primera vez que ejecutes la aplicación.

## Dependencias

- Java 8 o superior
- SQLite JDBC Driver 3.45.1.0 (incluido en lib/)
