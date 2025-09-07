package Ejercicio3;

public class MainLSP {
    public static void main(String[] args) {
        Vehiculo v1 = new Bicicleta();
        Vehiculo v2 = new Coche();

        v1.acelerar();
        v2.acelerar();
    }
}

