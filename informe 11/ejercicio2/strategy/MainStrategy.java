package strategy;

import java.util.*;

public class MainStrategy {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Producto p1 = new Producto("Gaseosa", 5);
        Producto p2 = new Producto("Gaseosa", 5);
        Producto p3 = new Producto("Snack", 3);

        List<Producto> productos = Arrays.asList(p1, p2, p3);

        CalculadoraDePrecios calc = new CalculadoraDePrecios();

        System.out.println("Seleccione una estrategia:");
        System.out.println("1. Sin descuento");
        System.out.println("2. Descuento fijo 10%");
        System.out.println("3. Descuento porcentual (30% por dos iguales)");
        System.out.println("4. Descuento acumulado (50% al más barato si hay 3+)");

        int opcion = sc.nextInt();

        switch(opcion) {
            case 1: calc.setStrategy(new SinDescuento()); break;
            case 2: calc.setStrategy(new DescuentoFijo()); break;
            case 3: calc.setStrategy(new DescuentoPorcentual()); break;
            case 4: calc.setStrategy(new DescuentoPorcentualAcumulado()); break;
            default:
                System.out.println("Opción no válida");
                return;
        }

        double resultado = calc.calcularPrecio(productos);
        System.out.println("Precio final: " + resultado);
    }
}
