package actividad4;

import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {
    protected String numeroCuenta;
    protected String titular;
    protected double saldo;
    protected List<String> historial;

    public CuentaBancaria(String numeroCuenta, String titular, double saldo) {
        if (saldo < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo.");
        }
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
        this.historial = new ArrayList<>();
        historial.add("Cuenta creada con saldo inicial: " + saldo);
    }

    public void depositar(double monto) {
        if (monto <= 0) throw new IllegalArgumentException("Monto inválido");
        saldo += monto;
        historial.add("Depósito: +" + monto);
    }

    public void retirar(double monto) {
        if (monto <= 0) throw new IllegalArgumentException("Monto inválido");
        if (monto > saldo) throw new IllegalArgumentException("Saldo insuficiente");
        saldo -= monto;
        historial.add("Retiro: -" + monto);
    }

    public String getNumeroCuenta() { return numeroCuenta; }
    public String getTitular() { return titular; }
    public double getSaldo() { return saldo; }
    public List<String> getHistorial() { return historial; }
}


