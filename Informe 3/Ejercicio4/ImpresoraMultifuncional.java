package Ejercicio4;

public class ImpresoraMultifuncional implements Imprimible, Escaneable {
    @Override
    public void imprimir(String documento) {
        System.out.println("Imprimiendo en multifuncional: " + documento);
    }

    @Override
    public void escanear(String documento) {
        System.out.println("Escaneando: " + documento);
    }
}
