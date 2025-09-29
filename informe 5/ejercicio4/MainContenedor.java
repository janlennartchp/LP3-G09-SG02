package ejercicio4;

public class MainContenedor {
    public static void main(String[] args) {
        Contenedor<String, Integer> contenedor = new Contenedor<>();
        contenedor.agregarPar("A", 1);
        contenedor.agregarPar("B", 2);
        contenedor.agregarPar("C", 3);

        System.out.println("Contenido del contenedor:");
        contenedor.mostrarPares();

        System.out.println("\nPar en posición 1: " + contenedor.obtenerPar(1));

        System.out.println("\nTodos los pares: " + contenedor.obtenerTodosLosPares());
    }
}
