package paquete;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class AudioPlayer extends JFrame {

    private Clip clip;
    private long pausa = 0;

    public AudioPlayer() {
        setTitle("Reproductor de Audio");
        setSize(350, 120);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton play = new JButton("Reproducir");
        JButton pause = new JButton("Pausar");
        JButton resume = new JButton("Reanudar");

        play.addActionListener(e -> reproducir());
        pause.addActionListener(e -> pausar());
        resume.addActionListener(e -> reanudar());

        add(play); add(pause); add(resume);
        cargarAudio();
    }

    private void cargarAudio() {
        try {
            File f = new File("audio.wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(f);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error cargando audio");
        }
    }

    private void reproducir() {
        clip.setMicrosecondPosition(0);
        clip.start();
    }

    private void pausar() {
        pausa = clip.getMicrosecondPosition();
        clip.stop();
    }

    private void reanudar() {
        clip.setMicrosecondPosition(pausa);
        clip.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AudioPlayer().setVisible(true));
    }
}
