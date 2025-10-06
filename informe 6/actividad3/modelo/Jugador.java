package modelo;

public class Jugador {
    private String nombre;
    private int salud;
    private int nivel;
    private InventarioModel inventario;
    private Item armaEquipada;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.salud = 100;
        this.nivel = 1;
        this.inventario = new InventarioModel();
        this.armaEquipada = null;
    }

    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public int getNivel() { return nivel; }
    public InventarioModel getInventario() { return inventario; }

    public void equiparArma(Item arma) {
        if (arma != null && arma.getTipo().equalsIgnoreCase("Arma")) {
            armaEquipada = arma;
            System.out.println("🔪 " + nombre + " ha equipado " + arma.getNombre());
        } else {
            System.out.println("❌ No puedes equipar este objeto.");
        }
    }

    public void atacar(Enemigo enemigo) {
        if (enemigo.getSalud() <= 0) {
            System.out.println("⚠️ El enemigo ya ha sido derrotado.");
            return;
        }

        int dañoBase = 10;
        if (armaEquipada != null) {
            dañoBase += 10;
            System.out.println("💥 " + nombre + " ataca con " + armaEquipada.getNombre() + " causando " + dañoBase + " de daño.");
        } else {
            System.out.println("👊 " + nombre + " golpea causando " + dañoBase + " de daño.");
        }
        enemigo.recibirDaño(dañoBase);
    }

    public void usarObjeto(String nombreItem) {
        Item item = inventario.buscarItem(nombreItem);
        if (item != null && item.getTipo().equalsIgnoreCase("Poción")) {
            item.usarItem();
            salud += 20;
            if (salud > 100) salud = 100;
            System.out.println("🧪 " + nombre + " ha usado una poción. Salud actual: " + salud);
        } else {
            System.out.println("❌ No tienes ese objeto o no se puede usar.");
        }
    }

    public void recibirDaño(int daño) {
        salud -= daño;
        if (salud < 0) salud = 0;
        System.out.println("💔 " + nombre + " ha recibido " + daño + " de daño. Salud restante: " + salud);
    }

    public boolean estaVivo() {
        return salud > 0;
    }
}
