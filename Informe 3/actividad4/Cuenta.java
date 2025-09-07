package actividad4;

public class Cuenta {
    private double saldo;

    public Cuenta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) { saldo += monto; }
    public void retirar(double monto) { saldo -= monto; }

    @Override
    public String toString() {
        return "Saldo: " + saldo;
    }
}

