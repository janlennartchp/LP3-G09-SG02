package actividad2;

public class PruebaCuentaBancaria {
    public static void main(String[] args) {
        // Creamos las cuentas bancarias
        CuentaBancaria cuenta1 = new CuentaBancaria("12345", "Juan Pérez", 1000.00);
        CuentaBancaria cuenta2 = new CuentaBancaria("67890", "Ana García", 500.00);
        CuentaBancaria cuenta3 = new CuentaBancaria("11223", "Carlos Díaz", 150.00);

        try {
            // Realizar transferencia válida
            cuenta1.transferir(cuenta2, 200.00);
            System.out.println("Transferencia exitosa de 200.00 de cuenta1 a cuenta2");
            System.out.println("Saldo cuenta1: " + cuenta1.getSaldo());
            System.out.println("Saldo cuenta2: " + cuenta2.getSaldo());

            // Intentar transferir más dinero del que hay en cuenta1
            cuenta1.transferir(cuenta2, 2000.00);  // Esto lanzará una excepción SaldoInsuficienteException

        } catch (CuentaNoEncontradaException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (SaldoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Intentar cerrar cuenta con saldo positivo
            cuenta3.cerrarCuenta();  // Esto lanzará una excepción SaldoNoCeroException

        } catch (SaldoNoCeroException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Intentar realizar transferencia a una cuenta no encontrada
            CuentaBancaria cuenta4 = CuentaBancaria.obtenerCuenta("99999");  // Cuenta no existe
            cuenta1.transferir(cuenta4, 100.00);  // Esto lanzará una excepción CuentaNoEncontradaException

        } catch (CuentaNoEncontradaException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (SaldoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

