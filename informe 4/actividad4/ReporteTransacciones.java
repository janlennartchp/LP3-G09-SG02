package actividad4;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReporteTransacciones {

    // Generar reporte en archivo
    public static void generarReporte(CuentaBancaria cuenta) throws HistorialVacioException, IOException {
        if (cuenta.getHistorial().isEmpty()) {
            throw new HistorialVacioException("No hay transacciones para generar el reporte.");
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter("reporte_" + cuenta.getNumeroCuenta() + ".txt"))) {
            writer.println("=== Reporte de Transacciones ===");
            writer.println("Cuenta: " + cuenta.getNumeroCuenta());
            writer.println("Titular: " + cuenta.getTitular());
            writer.println("Saldo actual: " + cuenta.getSaldo());
            writer.println("\nHistorial:");
            for (String t : cuenta.getHistorial()) {
                writer.println("- " + t);
            }
        }
    }

    // Leer datos desde archivo
    public static void leerReporte(String nombreArchivo) throws IOException {
        try (Scanner scanner = new Scanner(new java.io.File(nombreArchivo))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }
}

