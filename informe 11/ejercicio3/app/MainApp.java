import command.*;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Observer
        Notificacion sistema = new Notificacion();
        sistema.attach(new Usuario("Carlos"));
        sistema.attach(new Usuario("María"));

        // Strategy
        List<Producto> carrito = new ArrayList<>();
        CalculadoraDePrecios calc = new CalculadoraDePrecios();

        // Command
        InvokerMenu menu = new InvokerMenu();

        menu.addCommand(1, new AgregarProductoCommand(carrito, new Producto("Gaseosa", 5)));
        menu.addCommand(2, new AgregarProductoCommand(carrito, new Producto("Galletas", 3)));

        menu.addCommand(3, new MostrarCarritoCommand(carrito));

        // Aplicar descuentos
        menu.addCommand(4, new AplicarDescuentoCommand(carrito, new SinDescuento(), calc));
        menu.addCommand(5, new AplicarDescuentoCommand(carrito, new DescuentoFijo(), calc));
        menu.addCommand(6, new AplicarDescuentoCommand(carrito, new DescuentoPorcentual(), calc));
        menu.addCommand(7, new AplicarDescuentoCommand(carrito, new DescuentoPorcentualAcumulado(), calc));

        // Notificar usuarios
        menu.addCommand(8, new NotificarCommand(sistema, "Nueva oferta disponible!"));

        // Salir
        menu.addCommand(9, new ExitCommand());

        // Bucle principal
        while (true) {
            System.out.println("\n MENÚ ");
            System.out.println("1. Agregar Gaseosa");
            System.out.println("2. Agregar Galletas");
            System.out.println("3. Mostrar carrito");
            System.out.println("4. Sin descuento");
            System.out.println("5. Descuento 10%");
            System.out.println("6. Descuento 30% (2 iguales)");
            System.out.println("7. Descuento 50% (3 productos)");
            System.out.println("8. Notificar usuarios");
            System.out.println("9. Salir");
            System.out.print("Seleccione: ");

            int opcion = sc.nextInt();
            menu.ejecutar(opcion);
        }
    }
}
