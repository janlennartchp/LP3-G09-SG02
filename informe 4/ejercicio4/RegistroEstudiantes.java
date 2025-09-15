package ejercicio4;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class RegistroEstudiantes {
    private List<String> estudiantes;

    public RegistroEstudiantes() {
        estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del estudiante no puede ser nulo o vacío.");
        }
        estudiantes.add(nombre);
    }

    public String buscarEstudiante(String nombre) {
        for (String est : estudiantes) {
            if (est.equalsIgnoreCase(nombre)) {
                return est;
            }
        }
        throw new NoSuchElementException("Estudiante no encontrado: " + nombre);
    }

    public static void main(String[] args) {
        RegistroEstudiantes registro = new RegistroEstudiantes();

        try {
            registro.agregarEstudiante("Ana");
            registro.agregarEstudiante("Luis");
            registro.agregarEstudiante(""); // lanza excepción
        } catch (IllegalArgumentException e) {
            System.out.println("Error al agregar estudiante: " + e.getMessage());
        }

        try {
            System.out.println("Encontrado: " + registro.buscarEstudiante("Luis"));
            System.out.println("Encontrado: " + registro.buscarEstudiante("Carlos")); // lanza excepción
        } catch (NoSuchElementException e) {
            System.out.println("Error en búsqueda: " + e.getMessage());
        }
    }
}

