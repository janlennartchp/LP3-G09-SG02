package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class ReproductorVideo extends JFrame {
    private JPanel panelVideo;
    private JButton btnCargar, btnPlay, btnPause, btnStop;
    private JLabel lblEstado;
    private JSlider sliderProgreso;
    
    public ReproductorVideo() {
        setTitle("Reproductor de Video");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Panel principal de video
        panelVideo = new JPanel();
        panelVideo.setBackground(Color.BLACK);
        panelVideo.setPreferredSize(new Dimension(640, 480));
        panelVideo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        
        // Panel de controles
        JPanel panelControles = new JPanel(new BorderLayout());
        
        // Barra de progreso
        sliderProgreso = new JSlider(0, 100, 0);
        sliderProgreso.setMajorTickSpacing(10);
        sliderProgreso.setPaintTicks(true);
        panelControles.add(sliderProgreso, BorderLayout.NORTH);
        
        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        btnCargar = new JButton("Cargar Video");
        btnPlay = new JButton("▶ Play");
        btnPause = new JButton("⏸ Pausa");
        btnStop = new JButton("⏹ Stop");
        
        btnCargar.addActionListener(this::cargarVideo);
        btnPlay.addActionListener(this::reproducir);
        btnPause.addActionListener(this::pausar);
        btnStop.addActionListener(this::detener);
        
        // Inicialmente deshabilitados
        btnPlay.setEnabled(false);
        btnPause.setEnabled(false);
        btnStop.setEnabled(false);
        
        panelBotones.add(btnCargar);
        panelBotones.add(btnPlay);
        panelBotones.add(btnPause);
        panelBotones.add(btnStop);
        
        panelControles.add(panelBotones, BorderLayout.CENTER);
        
        // Label de estado
        lblEstado = new JLabel("Sin video cargado");
        lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
        panelControles.add(lblEstado, BorderLayout.SOUTH);
        
        // Agregar componentes
        add(panelVideo, BorderLayout.CENTER);
        add(panelControles, BorderLayout.SOUTH);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void cargarVideo(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
            "Videos", "mp4", "avi", "mov", "wmv", "flv"));
        
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File archivo = chooser.getSelectedFile();
            
            // Simulación de carga de video
            lblEstado.setText("Video cargado: " + archivo.getName());
            
            // Habilitar controles
            btnPlay.setEnabled(true);
            btnStop.setEnabled(true);
            
            // Mostrar mensaje en panel de video
            panelVideo.removeAll();
            JLabel lblVideo = new JLabel("Video: " + archivo.getName(), 
                                        SwingConstants.CENTER);
            lblVideo.setForeground(Color.WHITE);
            lblVideo.setFont(new Font("Arial", Font.BOLD, 16));
            panelVideo.setLayout(new GridBagLayout());
            panelVideo.add(lblVideo);
            panelVideo.revalidate();
            panelVideo.repaint();
        }
    }
    
    private void reproducir(ActionEvent e) {
        lblEstado.setText("Reproduciendo...");
        btnPlay.setEnabled(false);
        btnPause.setEnabled(true);
        btnStop.setEnabled(true);
        
        // Simulación de reproducción con timer
        Timer timer = new Timer(100, evt -> {
            int valor = sliderProgreso.getValue();
            if (valor < 100) {
                sliderProgreso.setValue(valor + 1);
            } else {
                ((Timer)evt.getSource()).stop();
                detener(null);
            }
        });
        timer.start();
    }
    
    private void pausar(ActionEvent e) {
        lblEstado.setText("En pausa");
        btnPlay.setEnabled(true);
        btnPause.setEnabled(false);
    }
    
    private void detener(ActionEvent e) {
        lblEstado.setText("Detenido");
        btnPlay.setEnabled(true);
        btnPause.setEnabled(false);
        btnStop.setEnabled(true);
        sliderProgreso.setValue(0);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ReproductorVideo());
    }
}
