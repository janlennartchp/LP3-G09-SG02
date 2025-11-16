package paquete;

//Fig. 12.41: MarcoBorderLayout.java
//BorderLayout que contiene cinco botones.

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class MarcoBorderLayout extends JFrame implements ActionListener
{
 private final JButton botones[]; // arreglo de botones para ocultar porciones
 private static final String nombres[] = {
     "Ocultar Norte", 
     "Ocultar Sur",
     "Ocultar Este", 
     "Ocultar Oeste", 
     "Ocultar Centro"
 };

 private final BorderLayout esquema;

 // establece la GUI y el manejo de eventos
 public MarcoBorderLayout()
 {
     super("Chavez y Alavrez");

     esquema = new BorderLayout(5, 5); // espacios de 5 píxeles
     setLayout(esquema);

     botones = new JButton[nombres.length];

     // crea objetos JButton y registra componentes de escucha para ellos
     for (int cuenta = 0; cuenta < nombres.length; cuenta++)
     {
         botones[cuenta] = new JButton(nombres[cuenta]);
         botones[cuenta].addActionListener(this);
     }

     add(botones[0], BorderLayout.NORTH);
     add(botones[1], BorderLayout.SOUTH);
     add(botones[2], BorderLayout.EAST);
     add(botones[3], BorderLayout.WEST);
     add(botones[4], BorderLayout.CENTER);
 }

 // maneja los eventos de botón
 @Override
 public void actionPerformed(ActionEvent evento)
 {
     // comprueba el origen del evento y ajusta los botones acorde
     for (JButton boton : botones)
     {
         if (evento.getSource() == boton)
             boton.setVisible(false);   // oculta el botón que se presionó
         else
             boton.setVisible(true);    // muestra los demás
     }

     esquema.layoutContainer(getContentPane()); // redistribuye el contenido
 }
} // fin de la clase MarcoBorderLayout
