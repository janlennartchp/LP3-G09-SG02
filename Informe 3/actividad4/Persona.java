package actividad4;

public class Persona {
    private String nombre;
    private Cuenta cuenta;

    public Persona(String nombre, double saldoInicial) {
        this.nombre = nombre;
        this.cuenta = new Cuenta(saldoInicial);
    }

    public void operarCuenta(double deposito, double retiro) {
        cuenta.depositar(deposito);
        cuenta.retirar(retiro);
    }

    @Override
    public String toString() {
        return "Persona: " + nombre + " | " + cuenta.toString();
    }
}

