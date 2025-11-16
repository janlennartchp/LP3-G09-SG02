package paquete; // ← elimínalo si no usas paquetes

import javax.swing.JFrame;

public class DemoFlowLayout
{
    public static void main(String[] args)
    {
        MarcoFlowLayout marcoFlowLayout = new MarcoFlowLayout();
        marcoFlowLayout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoFlowLayout.setSize(300, 75);
        marcoFlowLayout.setVisible(true);
    }
}

