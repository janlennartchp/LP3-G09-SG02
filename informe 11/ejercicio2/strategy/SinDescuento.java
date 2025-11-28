package strategy;
import java.util.List;
public class SinDescuento implements Strategy{
    public double aplicarDescuento(List<Producto> p){ return p.stream().mapToDouble(Producto::getPrecio).sum();}
}