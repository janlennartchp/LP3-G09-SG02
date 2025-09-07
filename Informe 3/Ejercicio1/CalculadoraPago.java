package Ejercicio1;

public class CalculadoraPago {
    public double calcularPagoMensual(Empleado empleado) {
        // Aquí podrías añadir reglas específicas por departamento o bonificaciones
        return empleado.getSalarioBase();
    }
}