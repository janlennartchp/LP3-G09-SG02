package paquete;

//Aplicación basada en la Guía de Práctica - Gráfico de Líneas con Swing
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraficoTemperaturaSemana extends JFrame {

 private JTextField[] campos = new JTextField[7];
 private PanelGrafico panelGrafico = new PanelGrafico();
 private String[] dias = {"Lun","Mar","Mie","Jue","Vie","Sab","Dom"};

 public GraficoTemperaturaSemana() {
     setTitle("Gráfico de Temperaturas Semanales");
     setSize(700, 500);
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     setLocationRelativeTo(null);

     JPanel panelIngreso = new JPanel(new GridLayout(2, 7, 5, 5));

     // Crear y agregar campos de texto
     for (int i = 0; i < 7; i++) {
         JPanel p = new JPanel(new BorderLayout());
         JLabel lbl = new JLabel(dias[i], JLabel.CENTER);
         campos[i] = new JTextField("20");
         p.add(lbl, BorderLayout.NORTH);
         p.add(campos[i], BorderLayout.CENTER);
         panelIngreso.add(p);
     }

     JButton btnMostrar = new JButton("Mostrar Gráfico");
     btnMostrar.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             actualizarGrafico();
         }
     });

     add(panelIngreso, BorderLayout.NORTH);
     add(btnMostrar, BorderLayout.SOUTH);
     add(panelGrafico, BorderLayout.CENTER);
 }

 private void actualizarGrafico() {
     double[] valores = new double[7];

     try {
         for (int i = 0; i < 7; i++) {
             valores[i] = Double.parseDouble(campos[i].getText());
         }
         panelGrafico.setTemperaturas(valores);
     } catch (NumberFormatException e) {
         JOptionPane.showMessageDialog(this,
                 "Ingrese valores numéricos válidos en todos los días");
     }
 }

 public static void main(String[] args) {
     SwingUtilities.invokeLater(() -> new GraficoTemperaturaSemana().setVisible(true));
 }
}

//PANEL DONDE SE DIBUJA EL GRÁFICO
class PanelGrafico extends JPanel {

 private double[] temps = {20,20,20,20,20,20,20};
 private String[] dias = {"Lun","Mar","Mie","Jue","Vie","Sab","Dom"};

 public void setTemperaturas(double[] nuevas) {
     temps = nuevas;
     repaint(); // Redibujar gráfico
 }

 @Override
 protected void paintComponent(Graphics g) {
     super.paintComponent(g);

     Graphics2D g2 = (Graphics2D) g;
     g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
             RenderingHints.VALUE_ANTIALIAS_ON);

     int w = getWidth();
     int h = getHeight();
     int margen = 50;

     // Área de dibujo del gráfico
     int ancho = w - 2 * margen;
     int alto = h - 2 * margen;

     // Ejes del gráfico
     g2.drawLine(margen, margen, margen, margen + alto);
     g2.drawLine(margen, margen + alto, margen + ancho, margen + alto);

     // Calcular escala
     double min = temps[0], max = temps[0];
     for (double t : temps) {
         if (t < min) min = t;
         if (t > max) max = t;
     }
     if (min == max) max += 1; // evitar división por 0

     int puntos = temps.length;
     int separacion = ancho / (puntos - 1);

     int prevX = -1, prevY = -1;

     for (int i = 0; i < puntos; i++) {
         int x = margen + i * separacion;
         int y = (int)(margen + alto - (temps[i] - min) * alto / (max - min));

         // Dibujar punto
         g2.setColor(Color.RED);
         g2.fillOval(x - 4, y - 4, 8, 8);

         // Unir con línea al anterior
         if (i > 0) {
             g2.setColor(Color.BLUE);
             g2.setStroke(new BasicStroke(2));
             g2.drawLine(prevX, prevY, x, y);
         }

         // Etiquetas de valores y días
         g2.setColor(Color.BLACK);
         g2.drawString(String.valueOf(temps[i]), x - 10, y - 10);
         g2.drawString(dias[i], x - 10, margen + alto + 20);

         prevX = x;
         prevY = y;
     }

     g2.drawString("Gráfico de Temperaturas", margen, margen - 10);
 }
}
