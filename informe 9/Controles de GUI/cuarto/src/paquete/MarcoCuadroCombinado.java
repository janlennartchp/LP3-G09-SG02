package paquete;

import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class MarcoCuadroCombinado extends JFrame
{
    private final JComboBox<String> imagenesJComboBox;
    private final JLabel etiqueta;

    private static final String[] nombres = {
        "blanco.png", 
        "amarillo.jpg", 
        "verde.jpg", 
        "celeste.jpg"
    };

    private final Icon[] iconos = new Icon[nombres.length];

    {
        for (int i = 0; i < nombres.length; i++) {
            java.net.URL url = getClass().getResource(nombres[i]);
            if (url != null) {
                iconos[i] = new ImageIcon(url);
            } else {
                // ícono vacío o texto alternativo
                iconos[i] = new ImageIcon();
            }
        }
    }

    public MarcoCuadroCombinado()
    {
        super("Chavez y Alvarez");
        setLayout(new FlowLayout());

        imagenesJComboBox = new JComboBox<>(nombres);
        imagenesJComboBox.setMaximumRowCount(3);

        etiqueta = new JLabel("Seleccione una imagen");
        add(imagenesJComboBox);
        add(etiqueta);

        imagenesJComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evento) {
                if (evento.getStateChange() == ItemEvent.SELECTED) {
                    etiqueta.setText(nombres[imagenesJComboBox.getSelectedIndex()]);
                    etiqueta.setIcon(iconos[imagenesJComboBox.getSelectedIndex()]);
                }
            }
        });
    }
}
