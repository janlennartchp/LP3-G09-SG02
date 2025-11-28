package strategy;
import java.util.*;
public class DescuentoPorcentualAcumulado implements Strategy{
    public double aplicarDescuento(List<Producto> p){
        if(p.size()>=3){
            Producto barato=p.stream().min(Comparator.comparingDouble(Producto::getPrecio)).get();
            double desc=barato.getPrecio()*0.50;
            double total=p.stream().mapToDouble(Producto::getPrecio).sum();
            return total-desc;
        }
        return p.stream().mapToDouble(Producto::getPrecio).sum();
    }
}