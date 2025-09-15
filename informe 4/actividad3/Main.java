package actividad3;

public class Main {
    public static void main(String[] args) {
        CuentaCredito cuenta1 = new CuentaCredito("001", "Juan Pérez", 500, 300);
        CuentaBancaria cuenta2 = new CuentaBancaria("002", "Ana Torres", 200);

        try {
            cuenta1.retirar(700); // Esto es válido (queda en -200, dentro del límite de -300)
            System.out.println("Retiro exitoso. Saldo actual: " + cuenta1.getSaldo());

            cuenta1.transferir(cuenta2, 700); // Esto excede el límite de crédito
            System.out.println("Transferencia realizada.");
        } catch (LimiteCreditoExcedidoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

