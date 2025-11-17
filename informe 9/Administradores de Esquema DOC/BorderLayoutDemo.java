package actividad1;

import javax.swing.*;
import java.awt.BorderLayout;

public class BorderLayoutDemo extends JFrame {
    
    public BorderLayoutDemo() {
        super("BorderLayout - Actividad 1");
        setLayout(new BorderLayout());
        
        add(new JButton("NORTE"), BorderLayout.NORTH);
        add(new JButton("SUR"), BorderLayout.SOUTH);
        add(new JButton("ESTE"), BorderLayout.EAST);
        add(new JButton("OESTE"), BorderLayout.WEST);
        add(new JButton("CENTRO"), BorderLayout.CENTER);
        
        setSize(420, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new BorderLayoutDemo();
    }
}
