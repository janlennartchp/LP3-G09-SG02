package strategy;
import java.util.List;
public class DescuentoFijo implements Strategy{
    public double aplicarDescuento(List<Producto> p){
        double total=p.stream().mapToDouble(Producto::getPrecio).sum();
        return total*0.90;
    }
}