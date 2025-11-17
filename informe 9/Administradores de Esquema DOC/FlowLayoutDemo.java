package actividad1;

import javax.swing.*;
import java.awt.FlowLayout;

public class FlowLayoutDemo extends JFrame {
    
    public FlowLayoutDemo() {
        super("FlowLayout Demo");
        setLayout(new FlowLayout());
        
        add(new JButton("Botón 1"));
        add(new JButton("Botón 2"));
        add(new JButton("Botón 3"));
        
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new FlowLayoutDemo();
    }
}
