package paquete;

public class BajarVolumenCommand implements Comando {
    private Televisor tv;

    public BajarVolumenCommand(Televisor tv) {
        this.tv = tv;
    }

    @Override
    public void ejecutar() {
        tv.bajarVolumen();
    }
}
