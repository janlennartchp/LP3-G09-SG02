public class SistemaGestionCursos {
    public static void main(String[] args) {
        // Crear profesores
        Profesor prof1 = new Profesor("Ana Torres", "12345678", "Programación");
        Profesor prof2 = new Profesor("Carlos Ruiz", "87654321", "Matemáticas");
        Profesor prof3 = new Profesor("Laura Gómez", "44556677", "Ciencias");

        // Crear categorías
        Categoria cat1 = new Categoria("Programación");
        Categoria cat2 = new Categoria("Matemáticas");
        Categoria cat3 = new Categoria("Ciencias");

        // Crear cursos con categoría y profesor
        Curso curso1 = new Curso("Java POO", prof1, cat1);
        Curso curso2 = new Curso("Álgebra Lineal", prof2, cat2);
        Curso curso3 = new Curso("Física General", prof3, cat3);

        // Crear estudiantes
        Estudiante e1 = new Estudiante("Luis Pérez", "11223344", "2024001");
        Estudiante e2 = new Estudiante("María López", "22334455", "2024002");
        Estudiante e3 = new Estudiante("Pedro Sánchez", "33445566", "2024003");
        Estudiante e4 = new Estudiante("Andrea Torres", "55667788", "2024004");

        // Inscribir estudiantes en diferentes cursos
        curso1.inscribirEstudiante(e1);
        curso1.inscribirEstudiante(e2);
        curso2.inscribirEstudiante(e3);
        curso3.inscribirEstudiante(e4);

        // Crear sistema de gestión
        SistemaGestion sistema = new SistemaGestion();
        sistema.agregarCurso(curso1);
        sistema.agregarCurso(curso2);
        sistema.agregarCurso(curso3);

        // Mostrar información del sistema
        Curso.mostrarMaxEstudiantes(); // método de clase
        System.out.println("=== Cursos disponibles ===");
        sistema.mostrarCursos();
    }
}