package paquete;

public class SubirVolumenCommand implements Comando {
    private Televisor tv;

    public SubirVolumenCommand(Televisor tv) {
        this.tv = tv;
    }

    @Override
    public void ejecutar() {
        tv.subirVolumen();
    }
}
