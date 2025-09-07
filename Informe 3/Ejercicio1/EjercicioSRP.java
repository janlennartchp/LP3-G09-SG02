package Ejercicio1;

public class EjercicioSRP {
    public static void main(String[] args) {
        Empleado e1 = new Empleado("Juan", 1500, "Ventas");
        Empleado e2 = new Empleado("Ana", 2000, "IT");

        CalculadoraPago calculadora = new CalculadoraPago();

        System.out.println(e1.getNombre() + " cobra: $" + calculadora.calcularPagoMensual(e1));
        System.out.println(e2.getNombre() + " cobra: $" + calculadora.calcularPagoMensual(e2));
    }
}