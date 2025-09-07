package actividad4;

public class TestComposicion {
    public static void main(String[] args) {
        Persona p1 = new Persona("Ana", 1000);
        p1.operarCuenta(500, 200);
        System.out.println(p1);
    }
}

