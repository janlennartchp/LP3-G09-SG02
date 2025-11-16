package paquete;

import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;

public class MarcoLista extends JFrame
{
    private final JList<String> listaJListColores; // lista para mostrar colores

    // Nombres de los colores
    private static final String[] nombresColores = {
        "Negro", "Azul", "Cyan", "Gris oscuro", "Gris",
        "Verde", "Gris claro", "Magenta", "Naranja",
        "Rosa", "Rojo", "Blanco", "Amarillo"
    };

    // Colores reales correspondientes a cada nombre
    private static final Color[] colores = {
        Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY,
        Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,
        Color.PINK, Color.RED, Color.WHITE, Color.YELLOW
    };

    // Constructor: configura la lista y los eventos
    public MarcoLista()
    {
        super("Chavez y Alvarez");
        setLayout(new FlowLayout());

        // Crear la lista con los nombres
        listaJListColores = new JList<>(nombresColores);
        listaJListColores.setVisibleRowCount(5); // muestra 5 filas
        listaJListColores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // solo una selección

        // Agregar lista dentro de un JScrollPane (para permitir desplazamiento)
        add(new JScrollPane(listaJListColores));

        // Manejador de eventos (clase interna anónima)
        listaJListColores.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evento) {
                // Cambia el color de fondo según el elemento seleccionado
                getContentPane().setBackground(
                    colores[listaJListColores.getSelectedIndex()]
                );
            }
        });
    }
}

