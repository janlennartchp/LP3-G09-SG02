public class Empleado {
    private int id;
    private String nombre;
    private int edad;
    private double sueldo;

    public Empleado(int id, String nombre, int edad, double sueldo) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.sueldo = sueldo;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public double getSueldo() { return sueldo; }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", sueldo=" + sueldo +
                '}';
    }
}
