class Estudiante extends Persona {
    private String codigoAlumno;
    public Estudiante(String nombre, String dni, String codigoAlumno) {
        super(nombre, dni);
        this.codigoAlumno = codigoAlumno;
    }
    public String getCodigoAlumno() {
        return codigoAlumno;
    }
    public void setCodigoAlumno(String codigoAlumno) {
        this.codigoAlumno = codigoAlumno;
    }
    
    @Override
    public void mostrarInfo() {
        System.out.println("Estudiante: " + getNombre() + " | Código: " + codigoAlumno);
    }
}