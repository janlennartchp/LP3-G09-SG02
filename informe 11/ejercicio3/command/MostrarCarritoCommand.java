package command;

import java.util.List;
import strategy.Producto;

public class MostrarCarritoCommand implements Command {

    private List<Producto> carrito;

    public MostrarCarritoCommand(List<Producto> carrito) {
        this.carrito = carrito;
    }

    @Override
    public void execute() {
        System.out.println("--- Carrito actual ---");
        for (Producto p : carrito) {
            System.out.println(p.getNombre() + " - S/ " + p.getPrecio());
        }
    }
}
