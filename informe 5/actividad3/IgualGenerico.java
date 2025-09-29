package actividad3;

public class IgualGenerico {

    // Método genérico que compara dos objetos usando equals
    public static <T> boolean esIgualA(T a, T b) {
        if (a == null || b == null) {
            return a == b; // Ambos null son iguales, si solo uno lo es, no son iguales
        }
        return a.equals(b);
    }

    public static void main(String[] args) {
        // Pruebas con distintos tipos
        System.out.println("Comparando enteros: " + esIgualA(5, 5)); // true
        System.out.println("Comparando enteros distintos: " + esIgualA(5, 10)); // false
        System.out.println("Comparando cadenas iguales: " + esIgualA("Hola", "Hola")); // true
        System.out.println("Comparando cadenas distintas: " + esIgualA("Hola", "Mundo")); // false
        System.out.println("Comparando null con null: " + esIgualA(null, null)); // true
        System.out.println("Comparando null con objeto: " + esIgualA(null, "Texto")); // false

        Object obj1 = new Object();
        Object obj2 = obj1;
        Object obj3 = new Object();

        System.out.println("Comparando objetos iguales: " + esIgualA(obj1, obj2)); // true
        System.out.println("Comparando objetos distintos: " + esIgualA(obj1, obj3)); // false
    }
}
