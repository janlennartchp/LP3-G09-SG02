package ejercicio3;

public class Numero {
    private double valor;

    public Numero(double valor) {
        setValor(valor); // validación inicial
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("El valor no puede ser negativo.");
        }
        this.valor = valor;
    }

    public static void main(String[] args) {
        try {
            Numero n1 = new Numero(15);
            System.out.println("Número válido: " + n1.getValor());

            n1.setValor(-8); // lanza excepción
        } catch (IllegalArgumentException e) {
            System.out.println("Error al asignar valor: " + e.getMessage());
        }
    }
}

