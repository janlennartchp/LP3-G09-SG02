package command;

import java.util.HashMap;
import java.util.Map;

public class InvokerMenu {

    private Map<Integer, Command> comandos = new HashMap<>();

    public void addCommand(int opcion, Command command) {
        comandos.put(opcion, command);
    }

    public void ejecutar(int opcion) {
        Command c = comandos.get(opcion);
        if (c != null) c.execute();
        else System.out.println("Opción inválida");
    }
}
