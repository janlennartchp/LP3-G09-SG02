package command;

import java.util.List;
import strategy.*;

public class AplicarDescuentoCommand implements Command {

    private List<Producto> carrito;
    private CalculadoraDePrecios calc;
    private Strategy strategy;

    public AplicarDescuentoCommand(List<Producto> carrito, Strategy strategy, CalculadoraDePrecios calc) {
        this.carrito = carrito;
        this.strategy = strategy;
        this.calc = calc;
    }

    @Override
    public void execute() {
        calc.setStrategy(strategy);
        double total = calc.calcularPrecio(carrito);
        System.out.println("Total con descuento: S/ " + total);
    }
}
