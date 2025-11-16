package Paquete;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class MarcoCasillaVerificacion extends JFrame
{
    private JTextField campoTexto;         // muestra el texto con distintos estilos
    private JCheckBox negritaJCheckBox;    // casilla para negrita
    private JCheckBox cursivaJCheckBox;    // casilla para cursiva

    // Constructor
    public MarcoCasillaVerificacion()
    {
        super("Chavez y Alvarez");
        setLayout(new FlowLayout());

        // Campo de texto con fuente inicial
        campoTexto = new JTextField("Janlennart y Josh", 20);
        campoTexto.setFont(new Font("Serif", Font.PLAIN, 14));
        add(campoTexto);

        // Crear las casillas de verificación
        negritaJCheckBox = new JCheckBox("Negrita");
        cursivaJCheckBox = new JCheckBox("Cursiva");
        add(negritaJCheckBox);
        add(cursivaJCheckBox);

        // Registrar manejador de eventos
        ManejadorCheckBox manejador = new ManejadorCheckBox();
        negritaJCheckBox.addItemListener(manejador);
        cursivaJCheckBox.addItemListener(manejador);
    }

    // Clase interna privada para manejar los eventos de las casillas
    private class ManejadorCheckBox implements ItemListener
    {
        @Override
        public void itemStateChanged(ItemEvent evento)
        {
            Font tipoletra;

            // Determina las combinaciones de selección y cambia el estilo
            if (negritaJCheckBox.isSelected() && cursivaJCheckBox.isSelected())
                tipoletra = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
            else if (negritaJCheckBox.isSelected())
                tipoletra = new Font("Serif", Font.BOLD, 14);
            else if (cursivaJCheckBox.isSelected())
                tipoletra = new Font("Serif", Font.ITALIC, 14);
            else
                tipoletra = new Font("Serif", Font.PLAIN, 14);

            campoTexto.setFont(tipoletra);
        }
    }
}

