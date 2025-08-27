import java.util.ArrayList;
import java.util.List;

class SistemaGestion {
    private List<Curso> cursos;

    public SistemaGestion() {
        cursos = new ArrayList<>();
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    // Método de instancia
    public void agregarCurso(Curso c) {
        cursos.add(c);
    }

    // Método de instancia
    public void mostrarCursos() {
        for (Curso c : cursos) {
            c.mostrarInfo();
            System.out.println("----");
        }
    }
}