package paquete; // ← elimina esta línea si no estás usando paquetes

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class MarcoSeleccionMultiple extends JFrame
{
    private final JList<String> listaJListColores; // lista de colores
    private final JList<String> listaJListCopia;   // lista donde se copian los colores seleccionados
    private final JButton botonJButtonCopiar;     // botón para copiar los colores

    private static final String[] nombresColores = {
        "Negro", "Azul", "Cyan", "Gris oscuro", "Gris", "Verde",
        "Gris claro", "Magenta", "Naranja", "Rosa", "Rojo", "Blanco", "Amarillo"
    };

    // Constructor
    public MarcoSeleccionMultiple()
    {
        super("Chavez y Alvarez");
        setLayout(new FlowLayout());

        // Lista original
        listaJListColores = new JList<>(nombresColores);
        listaJListColores.setVisibleRowCount(5);
        listaJListColores.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(new JScrollPane(listaJListColores));

        // Botón para copiar
        botonJButtonCopiar = new JButton("Copiar >>>");
        botonJButtonCopiar.addActionListener(
            new ActionListener() // clase interna anónima
            {
                @Override
                public void actionPerformed(ActionEvent evento)
                {
                    // Copia los valores seleccionados a la segunda lista
                    listaJListCopia.setListData(
                        listaJListColores.getSelectedValuesList().toArray(new String[0])
                    );
                }
            }
        );
        add(botonJButtonCopiar);

        // Lista destino
        listaJListCopia = new JList<>();
        listaJListCopia.setVisibleRowCount(5);
        listaJListCopia.setFixedCellWidth(100);
        listaJListCopia.setFixedCellHeight(15);
        listaJListCopia.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        add(new JScrollPane(listaJListCopia));
    }
}
