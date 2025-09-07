package Ejercicio2;

public class EjercicioOCP {
    public static void main(String[] args) {
        Dibujable[] formas = { new Circulo(), new Rectangulo(), new Triangulo() };

        for (Dibujable f : formas) {
            f.dibujar();
        }
    }
}