package strategy;
import java.util.List;
public class DescuentoPorcentual implements Strategy{
    public double aplicarDescuento(List<Producto> p){
        if(p.size()==2 && p.get(0).getNombre().equals(p.get(1).getNombre())){
            return p.stream().mapToDouble(Producto::getPrecio).sum()*0.70;
        }
        return p.stream().mapToDouble(Producto::getPrecio).sum();
    }
}