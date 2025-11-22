package vista;

import javax.swing.*;
import javax.sound.sampled.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class ReproductorMusica extends JFrame {
    private Clip clip;
    private long pausaPosicion = 0;
    private JLabel lblCancion;
    private JButton btnCargar, btnPlay, btnPause, btnStop;
    private JSlider sliderVolumen;
    private JProgressBar progressBar;
    
    public ReproductorMusica() {
        setTitle("Reproductor de Música");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(400, 200);
        
        // Panel principal
        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Label de canción
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        lblCancion = new JLabel("Sin canción cargada");
        lblCancion.setFont(new Font("Arial", Font.BOLD, 14));
        panelPrincipal.add(lblCancion, gbc);
        
        // Barra de progreso
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        panelPrincipal.add(progressBar, gbc);
        
        // Botones de control
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        
        btnCargar = new JButton("📁 Cargar");
        gbc.gridx = 0;
        panelPrincipal.add(btnCargar, gbc);
        
        btnPlay = new JButton("▶ Play");
        btnPlay.setEnabled(false);
        gbc.gridx = 1;
        panelPrincipal.add(btnPlay, gbc);
        
        btnPause = new JButton("⏸ Pausa");
        btnPause.setEnabled(false);
        gbc.gridx = 2;
        panelPrincipal.add(btnPause, gbc);
        
        btnStop = new JButton("⏹ Stop");
        btnStop.setEnabled(false);
        gbc.gridx = 3;
        panelPrincipal.add(btnStop, gbc);
        
        // Control de volumen
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JPanel panelVolumen = new JPanel(new BorderLayout());
        panelVolumen.add(new JLabel("Volumen: "), BorderLayout.WEST);
        sliderVolumen = new JSlider(0, 100, 50);
        sliderVolumen.setMajorTickSpacing(25);
        sliderVolumen.setPaintTicks(true);
        sliderVolumen.setPaintLabels(true);
        panelVolumen.add(sliderVolumen, BorderLayout.CENTER);
        panelPrincipal.add(panelVolumen, gbc);
        
        // Agregar listeners
        btnCargar.addActionListener(e -> cargarAudio());
        btnPlay.addActionListener(e -> reproducir());
        btnPause.addActionListener(e -> pausar());
        btnStop.addActionListener(e -> detener());
        
        sliderVolumen.addChangeListener(e -> {
            if (clip != null) {
                ajustarVolumen();
            }
        });
        
        add(panelPrincipal, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void cargarAudio() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
            "Archivos de Audio", "wav", "au", "aiff"));
        
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                File archivo = chooser.getSelectedFile();
                
                // Cerrar clip anterior si existe
                if (clip != null && clip.isOpen()) {
                    clip.close();
                }
                
                // Cargar nuevo audio
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivo);
                clip = AudioSystem.getClip();
                clip.open(audioStream);
                
                lblCancion.setText("🎵 " + archivo.getName());
                
                // Habilitar controles
                btnPlay.setEnabled(true);
                btnStop.setEnabled(true);
                
                // Configurar barra de progreso
                progressBar.setMaximum((int) clip.getMicrosecondLength() / 1000000);
                
                // Actualizar progreso con timer
                Timer timer = new Timer(100, e -> actualizarProgreso());
                timer.start();
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, 
                    "Error al cargar el audio: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void reproducir() {
        if (clip != null) {
            if (pausaPosicion > 0) {
                clip.setMicrosecondPosition(pausaPosicion);
                pausaPosicion = 0;
            } else {
                clip.setFramePosition(0);
            }
            clip.start();
            btnPlay.setEnabled(false);
            btnPause.setEnabled(true);
        }
    }
    
    private void pausar() {
        if (clip != null && clip.isRunning()) {
            pausaPosicion = clip.getMicrosecondPosition();
            clip.stop();
            btnPlay.setEnabled(true);
            btnPause.setEnabled(false);
        }
    }
    
    private void detener() {
        if (clip != null) {
            clip.stop();
            clip.setFramePosition(0);
            pausaPosicion = 0;
            btnPlay.setEnabled(true);
            btnPause.setEnabled(false);
            progressBar.setValue(0);
        }
    }
    
    private void ajustarVolumen() {
        if (clip != null && clip.isOpen()) {
            try {
                FloatControl control = (FloatControl) clip.getControl(
                    FloatControl.Type.MASTER_GAIN);
                
                float valor = sliderVolumen.getValue() / 100.0f;
                float dB = (float) (Math.log(valor) / Math.log(10.0) * 20.0);
                control.setValue(dB);
            } catch (Exception ex) {
                // Algunos clips no soportan control de volumen
            }
        }
    }
    
    private void actualizarProgreso() {
        if (clip != null && clip.isRunning()) {
            int posicion = (int) (clip.getMicrosecondPosition() / 1000000);
            progressBar.setValue(posicion);
            
            if (clip.getMicrosecondPosition() >= clip.getMicrosecondLength()) {
                detener();
            }
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ReproductorMusica());
    }
}
