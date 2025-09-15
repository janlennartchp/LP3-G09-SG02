package actividad2;

// Clase CuentaBancaria
import java.util.HashMap;
import java.util.Map;

public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    private double saldo;

    // Mapa de cuentas (simula un sistema de cuentas en el banco)
    private static Map<String, CuentaBancaria> cuentasBancarias = new HashMap<>();

    // Constructor con validación
    public CuentaBancaria(String numeroCuenta, String titular, double saldo) {
        if (saldo < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo.");
        }
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;

        // Guardamos la cuenta en el sistema (simulación de un sistema de cuentas)
        cuentasBancarias.put(numeroCuenta, this);
    }

    // Método para depositar dinero
    public void depositar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser positivo.");
        }
        saldo += monto;
    }

    // Método para retirar dinero
    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser positivo.");
        }
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar el retiro.");
        }
        saldo -= monto;
    }

    // Método para transferir dinero a otra cuenta
    public void transferir(CuentaBancaria destino, double monto) throws CuentaNoEncontradaException, SaldoInsuficienteException {
        if (destino == null) {
            throw new CuentaNoEncontradaException("La cuenta de destino no existe.");
        }
        if (this.saldo < monto) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar la transferencia.");
        }
        this.retirar(monto);  // Retiramos de la cuenta origen
        destino.depositar(monto);  // Depositamos en la cuenta destino
    }

    // Método para cerrar la cuenta
    public void cerrarCuenta() throws SaldoNoCeroException {
        if (this.saldo > 0) {
            throw new SaldoNoCeroException("No se puede cerrar la cuenta con saldo positivo.");
        }
        cuentasBancarias.remove(this.numeroCuenta);  // Eliminamos la cuenta del sistema
    }

    // Métodos getters
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    // Método estático para obtener una cuenta por su número
    public static CuentaBancaria obtenerCuenta(String numeroCuenta) {
        return cuentasBancarias.get(numeroCuenta);
    }
}

