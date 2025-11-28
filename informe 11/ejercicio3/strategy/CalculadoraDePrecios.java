package strategy;
import java.util.List;
public class CalculadoraDePrecios{
    private Strategy strategy;
    public void setStrategy(Strategy s){ strategy=s; }
    public double calcularPrecio(List<Producto> p){ return strategy.aplicarDescuento(p);}
}