import vista.TiendaVista;
import controlador.TiendaControlador;

public class Main {
    public static void main(String[] args) {
        TiendaVista vista = new TiendaVista();
        TiendaControlador controlador = new TiendaControlador(vista);
        controlador.iniciar();
    }
}
