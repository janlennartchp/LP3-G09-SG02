package paquete;

import javax.swing.*;
import java.awt.*;

public class GraficoTemperaturas extends JPanel {

    private double[] temps = {20, 22, 21, 24, 25, 23, 22};

    public void actualizarDatos(double[] nuevos) {
        temps = nuevos;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth(), h = getHeight();

        g2.drawString("Temperaturas semanales", 20, 20);

        int x0 = 40, y0 = h - 40;
        g2.drawLine(x0, 20, x0, y0);
        g2.drawLine(x0, y0, w - 20, y0);

        int sep = (w - 80) / 6;

        for (int i = 0; i < temps.length - 1; i++) {
            int x1 = x0 + sep * i;
            int y1 = (int) (y0 - temps[i] * 5);
            int x2 = x0 + sep * (i + 1);
            int y2 = (int) (y0 - temps[i + 1] * 5);

            g2.fillOval(x1 - 4, y1 - 4, 8, 8);
            g2.drawLine(x1, y1, x2, y2);
        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Gráfico con Swing");
        GraficoTemperaturas gt = new GraficoTemperaturas();
        JTextField entrada = new JTextField("20,22,21,24,25,23,22", 20);
        JButton btn = new JButton("Actualizar");

        btn.addActionListener(e -> {
            try {
                String[] datos = entrada.getText().split(",");
                double[] nuevos = new double[7];
                for (int i = 0; i < 7; i++)
                    nuevos[i] = Double.parseDouble(datos[i]);
                gt.actualizarDatos(nuevos);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(f, "Ingrese 7 números separados por coma");
            }
        });

        f.add(entrada, BorderLayout.NORTH);
        f.add(gt, BorderLayout.CENTER);
        f.add(btn, BorderLayout.SOUTH);

        f.setSize(600, 400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}

