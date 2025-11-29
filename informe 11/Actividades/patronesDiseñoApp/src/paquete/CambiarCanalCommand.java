package paquete;

public class CambiarCanalCommand implements Comando {
    private Televisor tv;

    public CambiarCanalCommand(Televisor tv) {
        this.tv = tv;
    }

    @Override
    public void ejecutar() {
        tv.cambiarCanal();
    }
}
