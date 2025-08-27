import java.util.ArrayList;
import java.util.List;
class Curso implements Registrable {
    private String nombre;
    private Profesor profesor;     // Agregación
    private Categoria categoria;   // Composición
    private List<Estudiante> estudiantes;
    // Constante de clase
    public static final int MAX_ESTUDIANTES = 50;
    public Curso(String nombre, Profesor profesor, Categoria categoria) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.categoria = categoria;
        this.estudiantes = new ArrayList<>();
    }
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Profesor getProfesor() {
        return profesor;
    }
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    // Método de instancia
    public void inscribirEstudiante(Estudiante e) {
        if (estudiantes.size() < MAX_ESTUDIANTES) {
            estudiantes.add(e);
            System.out.println("Estudiante " + e.getNombre() + " inscrito en " + nombre);
        } else {
            System.out.println("El curso " + nombre + " está lleno.");
        }
    }
    // Método de instancia (polimórfico desde Registrable)
    @Override
    public void mostrarInfo() {
        System.out.println("Curso: " + nombre + " | Categoría: " + categoria.getNombre());
        profesor.mostrarInfo();
        System.out.println("Estudiantes inscritos: " + estudiantes.size());
    }
    // Método de clase
    public static void mostrarMaxEstudiantes() {
        System.out.println("Máximo permitido de estudiantes por curso: " + MAX_ESTUDIANTES);
    }
}