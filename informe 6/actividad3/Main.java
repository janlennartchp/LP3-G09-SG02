import modelo.*;
import vista.*;
import controlador.*;

public class Main {
    public static void main(String[] args) {
        // Crear jugador con inventario
        Jugador jugador = new Jugador("Lennart");
        jugador.getInventario().agregarItem(new Item("Espada de Hierro", 1, "Arma", "Una espada básica de hierro."));
        jugador.getInventario().agregarItem(new Item("Poción de Vida", 2, "Poción", "Restaura salud."));

        // Crear enemigo
        Enemigo enemigo = new Enemigo("Orco Salvaje", 2, "Bestia");

        // Vista y controlador del combate
        CombateView vista = new CombateView();
        CombateController combate = new CombateController(jugador, enemigo, vista);

        // Iniciar combate
        combate.iniciarCombate();
    }
}
