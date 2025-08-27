class Profesor extends Persona {
    private String especialidad;
    public Profesor(String nombre, String dni, String especialidad) {
        super(nombre, dni);
        this.especialidad = especialidad;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    @Override
    public void mostrarInfo() {
        System.out.println("Profesor: " + getNombre() + " | Especialidad: " + especialidad);
    }
}
