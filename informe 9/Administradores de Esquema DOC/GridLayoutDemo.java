package actividad1;

import javax.swing.*;
import java.awt.GridLayout;

public class GridLayoutDemo extends JFrame {
    
    public GridLayoutDemo() {
        super("GridLayout - Actividad 1");
        setLayout(new GridLayout(2, 3, 5, 5)); // 2 filas, 3 columnas, separación 5px
        
        add(new JButton("1"));
        add(new JButton("2"));
        add(new JButton("3"));
        add(new JButton("4"));
        add(new JButton("5"));
        add(new JButton("6"));
        
        setSize(360, 160);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new GridLayoutDemo();
    }
}
