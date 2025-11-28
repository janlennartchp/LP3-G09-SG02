package command;

public class ExitCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Saliendo del sistema...");
        System.exit(0);
    }
}
