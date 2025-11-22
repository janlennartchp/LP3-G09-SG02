package actividad3;

import javax.swing.*;
import java.awt.*;
import javax.sound.sampled.*;
import java.io.File;

public class ReproductorMusica extends JFrame {

    private Clip clip;
    private long pausaPosicion = 0;

    public ReproductorMusica() {
        super("Reproductor de Música");
        setLayout(new FlowLayout());

        JButton btnReproducir = new JButton("Reproducir");
        JButton btnPausar = new JButton("Pausar");
        JButton btnReanudar = new JButton("Reanudar");

        btnReproducir.addActionListener(e -> reproducir("sonidos/musica.wav"));
        btnPausar.addActionListener(e -> pausar());
        btnReanudar.addActionListener(e -> reanudar());

        add(btnReproducir);
        add(btnPausar);
        add(btnReanudar);

        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void reproducir(String ruta) {
        try {
            if (clip != null && clip.isRunning()) clip.stop();

            File archivo = new File(ruta);
            AudioInputStream audio = AudioSystem.getAudioInputStream(archivo);
            clip = AudioSystem.getClip();
            clip.open(audio);

            clip.setMicrosecondPosition(0);
            clip.start();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al reproducir: " + ex.getMessage());
        }
    }

    private void pausar() {
        if (clip != null && clip.isRunning()) {
            pausaPosicion = clip.getMicrosecondPosition();
            clip.stop();
        }
    }

    private void reanudar() {
        if (clip != null) {
            clip.setMicrosecondPosition(pausaPosicion);
            clip.start();
        }
    }

    public static void main(String[] args) {
        new ReproductorMusica();
    }
}

