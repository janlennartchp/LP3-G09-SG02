package ejercicio3;

public class Main {

    // Método genérico estático imprimirPar
    public static <F, S> void imprimirPar(Par<F, S> par) {
        System.out.println("Par recibido: " + par);
    }

    public static void main(String[] args) {
        Par<String, Integer> par1 = new Par<>("Edad", 25);
        Par<Double, Boolean> par2 = new Par<>(3.14, false);
        Par<Persona, Integer> par3 = new Par<>(new Persona("Carlos", 28), 100);

        imprimirPar(par1);
        imprimirPar(par2);
        imprimirPar(par3);
    }
}
