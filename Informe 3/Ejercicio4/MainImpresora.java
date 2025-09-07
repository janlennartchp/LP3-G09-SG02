package Ejercicio4;

public class MainImpresora {
    public static void main(String[] args) {
        Imprimible impresora = new Impresora();
        impresora.imprimir("Contrato.pdf");

        ImpresoraMultifuncional multifuncional = new ImpresoraMultifuncional();
        multifuncional.imprimir("Factura.pdf");
        multifuncional.escanear("Documento físico");
    }
}

