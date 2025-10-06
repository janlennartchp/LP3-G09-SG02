package controlador;

import modelo.Enemigo;
import modelo.Jugador;
import modelo.Item;
import vista.CombateView;
import java.util.Random;

public class CombateController {
    private Jugador jugador;
    private Enemigo enemigo;
    private CombateView vista;

    public CombateController(Jugador jugador, Enemigo enemigo, CombateView vista) {
        this.jugador = jugador;
        this.enemigo = enemigo;
        this.vista = vista;
    }

    public void iniciarCombate() {
        vista.mostrarMensaje("⚔️ ¡Comienza el combate entre " + jugador.getNombre() + " y " + enemigo.getNombre() + "!");
        while (jugador.estaVivo() && enemigo.estaVivo()) {
            vista.mostrarEstadoCombate(jugador, enemigo);
            String opcion = vista.mostrarMenuCombate();

            switch (opcion) {
                case "1":
                    jugador.atacar(enemigo);
                    break;
                case "2":
                    String item = vista.solicitarTexto("Ingrese el nombre del objeto a usar");
                    jugador.usarObjeto(item);
                    break;
                case "3":
                    String arma = vista.solicitarTexto("Ingrese el nombre del arma a equipar");
                    Item i = jugador.getInventario().buscarItem(arma);
                    jugador.equiparArma(i);
                    break;
                case "4":
                    vista.mostrarMensaje("🏃 " + jugador.getNombre() + " huye del combate.");
                    return;
                default:
                    vista.mostrarMensaje("❌ Opción no válida.");
                    continue;
            }

            if (!enemigo.estaVivo()) {
                vista.mostrarMensaje("🎉 ¡Has derrotado a " + enemigo.getNombre() + "!");
                break;
            }

            // Turno del enemigo (acción aleatoria)
            Random rand = new Random();
            if (rand.nextBoolean()) {
                enemigo.atacar(jugador);
            } else {
                vista.mostrarMensaje("😈 " + enemigo.getNombre() + " observa y se prepara para atacar.");
            }

            if (!jugador.estaVivo()) {
                vista.mostrarMensaje("💀 " + jugador.getNombre() + " ha sido derrotado...");
            }
        }
    }
}
