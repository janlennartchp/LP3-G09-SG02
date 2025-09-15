package actividad1;
public class PruebaCuentaBancaria {
    public static void main(String[] args) {
        try {
            // Crear cuenta con saldo válido
            CuentaBancaria cuenta1 = new CuentaBancaria("12345", "Juan Pérez", 1000.00);
            System.out.println("Cuenta creada: " + cuenta1.getTitular() + ", Número: " + cuenta1.getNumeroCuenta());
            
            // Probar depósito válido
            cuenta1.depositar(500.00);
            
            // Probar retiro válido
            cuenta1.retirar(200.00);
            
            // Probar retiro con saldo insuficiente
            cuenta1.retirar(1500.00);  // Esto debe lanzar la excepción SaldoInsuficienteException

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (SaldoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Crear cuenta con saldo negativo (debe lanzar IllegalArgumentException)
            CuentaBancaria cuenta2 = new CuentaBancaria("67890", "Ana García", -500.00);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Probar depósito con monto negativo (debe lanzar IllegalArgumentException)
            CuentaBancaria cuenta3 = new CuentaBancaria("11223", "Carlos Díaz", 200.00);
            cuenta3.depositar(-100.00);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
