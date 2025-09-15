package actividad3;

public class CuentaCredito extends CuentaBancaria {
    private double limiteCredito;

    public CuentaCredito(String numeroCuenta, String titular, double saldo, double limiteCredito) {
        super(numeroCuenta, titular, saldo);
        this.limiteCredito = limiteCredito;
    }

    @Override
    public void retirar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo.");
        }
        if (saldo - monto < -limiteCredito) {
            throw new LimiteCreditoExcedidoException("Límite de crédito excedido.");
        }
        saldo -= monto;
    }

    public void transferir(CuentaBancaria destino, double monto) {
        if (destino == null) {
            throw new IllegalArgumentException("La cuenta destino no existe.");
        }
        if (saldo - monto < -limiteCredito) {
            throw new LimiteCreditoExcedidoException("No se puede transferir, límite de crédito excedido.");
        }
        saldo -= monto;
        destino.depositar(monto);
    }
}

