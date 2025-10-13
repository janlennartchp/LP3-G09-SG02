public class Empleado {
    private int numero;
    private String nombre;
    private double sueldo;

    public Empleado(int numero, String nombre, double sueldo) {
        this.numero = numero;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    @Override
    public String toString() {
        return numero + "," + nombre + "," + sueldo;
    }

    public static Empleado fromString(String linea) {
        String[] partes = linea.split(",");
        if (partes.length == 3) {
            int numero = Integer.parseInt(partes[0]);
            String nombre = partes[1];
            double sueldo = Double.parseDouble(partes[2]);
            return new Empleado(numero, nombre, sueldo);
        }
        return null;
    }
}
