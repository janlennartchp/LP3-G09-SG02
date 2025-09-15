package actividad4;

import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria("001", "Juan Pérez", 500);

        cuenta.depositar(200);
        cuenta.retirar(100);

        try {
            // Generar reporte
            ReporteTransacciones.generarReporte(cuenta);
            System.out.println("Reporte generado con éxito.");

            // Leer reporte
            ReporteTransacciones.leerReporte("reporte_001.txt");

        } catch (HistorialVacioException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de archivo: " + e.getMessage());
        }
    }
}

