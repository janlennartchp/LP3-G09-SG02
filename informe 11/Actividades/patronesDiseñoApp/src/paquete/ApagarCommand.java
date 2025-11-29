package paquete;

public class ApagarCommand implements Comando {
    private Televisor tv;

    public ApagarCommand(Televisor tv) {
        this.tv = tv;
    }

    @Override
    public void ejecutar() {
        tv.apagar();
    }
}
