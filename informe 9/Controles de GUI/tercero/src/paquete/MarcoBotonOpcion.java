package paquete;

//Fig. 12.19: MarcoBotonOpcion.java
//Creación de botones de opción, usando ButtonGroup y JRadioButton.

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class MarcoBotonOpcion extends JFrame
{
 private final JTextField campoTexto;              // muestra el texto con distintos estilos
 private final Font tipoLetraSimple;               // tipo de letra simple
 private final Font tipoLetraNegrita;              // tipo de letra en negrita
 private final Font tipoLetraCursiva;              // tipo de letra en cursiva
 private final Font tipoLetraNegritaCursiva;       // tipo de letra en negrita y cursiva

 private final JRadioButton simpleJRadioButton;    // opción texto simple
 private final JRadioButton negritaJRadioButton;   // opción texto negrita
 private final JRadioButton cursivaJRadioButton;   // opción texto cursiva
 private final JRadioButton negritaCursivaJRadioButton; // opción texto negrita y cursiva

 private ButtonGroup grupoOpciones;                // agrupa los botones para selección única

 // Constructor
 public MarcoBotonOpcion()
 {
     super("Chavez y Alvarez");
     setLayout(new FlowLayout());

     campoTexto = new JTextField("Janlennart y Josh", 25);
     add(campoTexto);

     // Crear botones de opción
     simpleJRadioButton = new JRadioButton("Simple", true);
     negritaJRadioButton = new JRadioButton("Negrita", false);
     cursivaJRadioButton = new JRadioButton("Cursiva", false);
     negritaCursivaJRadioButton = new JRadioButton("Negrita/Cursiva", false);

     // Agregar botones al JFrame
     add(simpleJRadioButton);
     add(negritaJRadioButton);
     add(cursivaJRadioButton);
     add(negritaCursivaJRadioButton);

     // Agrupar los botones de opción para que solo uno pueda seleccionarse
     grupoOpciones = new ButtonGroup();
     grupoOpciones.add(simpleJRadioButton);
     grupoOpciones.add(negritaJRadioButton);
     grupoOpciones.add(cursivaJRadioButton);
     grupoOpciones.add(negritaCursivaJRadioButton);

     // Crear tipos de letra
     tipoLetraSimple = new Font("Serif", Font.PLAIN, 14);
     tipoLetraNegrita = new Font("Serif", Font.BOLD, 14);
     tipoLetraCursiva = new Font("Serif", Font.ITALIC, 14);
     tipoLetraNegritaCursiva = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
     campoTexto.setFont(tipoLetraSimple);

     // Registrar manejadores de eventos
     simpleJRadioButton.addItemListener(new ManejadorBotonOpcion(tipoLetraSimple));
     negritaJRadioButton.addItemListener(new ManejadorBotonOpcion(tipoLetraNegrita));
     cursivaJRadioButton.addItemListener(new ManejadorBotonOpcion(tipoLetraCursiva));
     negritaCursivaJRadioButton.addItemListener(new ManejadorBotonOpcion(tipoLetraNegritaCursiva));
 }

 // Clase interna privada para manejar eventos de los botones de opción
 private class ManejadorBotonOpcion implements ItemListener
 {
     private Font tipoLetra;

     public ManejadorBotonOpcion(Font f)
     {
         tipoLetra = f;
     }

     @Override
     public void itemStateChanged(ItemEvent evento)
     {
         campoTexto.setFont(tipoLetra);
     }
 }
}
