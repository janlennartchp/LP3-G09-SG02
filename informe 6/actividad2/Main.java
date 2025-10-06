import modelo.InventarioModel;
import vista.InventarioView;
import controlador.InventarioController;

public class Main {
    public static void main(String[] args) {
        InventarioModel modelo = new InventarioModel();
        InventarioView vista = new InventarioView();
        InventarioController controlador = new InventarioController(modelo, vista);
        controlador.iniciar();
    }
}
