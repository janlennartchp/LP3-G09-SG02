package Ejercicio1;

public class Empleado {
    private String nombre;
    private double salarioBase;
    private String departamento;

    public Empleado(String nombre, double salarioBase, String departamento) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
        this.departamento = departamento;
    }

    public String getNombre() { return nombre; }
    public double getSalarioBase() { return salarioBase; }
    public String getDepartamento() { return departamento; }
}
