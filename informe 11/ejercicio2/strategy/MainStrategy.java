package strategy;
import java.util.*;
public class MainStrategy{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        List<Producto> productos=new ArrayList<>();
        productos.add(new Producto("Gaseosa",5));
        productos.add(new Producto("Gaseosa",5));
        productos.add(new Producto("Snack",3));
        CalculadoraDePrecios calc=new CalculadoraDePrecios();
        System.out.println("1.Sin
2.Fijo
3.30%
4.50% al más barato");
        int op=sc.nextInt();
        switch(op){
            case 1: calc.setStrategy(new SinDescuento()); break;
            case 2: calc.setStrategy(new DescuentoFijo()); break;
            case 3: calc.setStrategy(new DescuentoPorcentual()); break;
            case 4: calc.setStrategy(new DescuentoPorcentualAcumulado()); break;
        }
        System.out.println("Total: "+calc.calcularPrecio(productos));
    }
}