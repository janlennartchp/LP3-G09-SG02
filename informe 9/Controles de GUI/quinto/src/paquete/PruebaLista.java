package paquete;
 // solo si estás usando un paquete, por ejemplo “paquete”
//Si tus archivos NO están en un paquete, borra esta línea.

import javax.swing.JFrame;

public class PruebaLista
{
 public static void main(String[] args)
 {
     MarcoLista marcoLista = new MarcoLista(); // crea objeto MarcoLista
     marcoLista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     marcoLista.setSize(350, 150);
     marcoLista.setVisible(true);
 }
}
