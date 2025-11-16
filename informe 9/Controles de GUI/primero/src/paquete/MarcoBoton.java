package paquete;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MarcoBoton extends JFrame {

    private final JButton botonJButtonSimple;   // botón con texto solamente
    private final JButton botonJButtonElegante; // botón con iconos

    // MarcoBoton agrega objetos JButton a JFrame
    public MarcoBoton() {
        super("Chavez y Alvarez");
        setLayout(new FlowLayout());

        botonJButtonSimple = new JButton("Botón Jan"); // botón con texto
        add(botonJButtonSimple); // agrega botonJButtonSimple a JFrame

        // Carga las imágenes desde la carpeta del paquete o recursos
        Icon insecto1 = new ImageIcon(getClass().getResource("negro.jpg"));
        Icon insecto2 = new ImageIcon(getClass().getResource("blanco.png"));

        botonJButtonElegante = new JButton("Botón Josh", insecto1); // establece la imagen
        botonJButtonElegante.setRolloverIcon(insecto2); // establece la imagen de sustitución
        add(botonJButtonElegante); // agrega botonJButtonElegante a JFrame

        // crea nuevo ManejadorBoton para manejar los eventos de botón
        ManejadorBoton manejador = new ManejadorBoton();
        botonJButtonElegante.addActionListener(manejador);
        botonJButtonSimple.addActionListener(manejador);
    }

    // clase interna para manejar eventos de botón
    private class ManejadorBoton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evento) {
            JOptionPane.showMessageDialog(
                MarcoBoton.this,
                String.format("Usted oprimió: %s", evento.getActionCommand())
            );
        }
    }

    // Método main para ejecutar
    public static void main(String[] args) {
        MarcoBoton marco = new MarcoBoton();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setSize(300, 200);
        marco.setVisible(true);
    }
}
