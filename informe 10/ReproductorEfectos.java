package actividad3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.File;

public class ReproductorEfectos extends JFrame {

    public ReproductorEfectos() {
        super("Reproductor de Efectos de Sonido");
        setLayout(new FlowLayout());

        JButton btnAplausos = new JButton("Aplausos");
        JButton btnCampana = new JButton("Campana");
        JButton btnExplosion = new JButton("Explosión");

        btnAplausos.addActionListener(e -> reproducirSonido("sonidos/aplausos.wav"));
        btnCampana.addActionListener(e -> reproducirSonido("sonidos/campana.wav"));
        btnExplosion.addActionListener(e -> reproducirSonido("sonidos/explosion.wav"));

        add(btnAplausos);
        add(btnCampana);
        add(btnExplosion);

        setSize(300, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void reproducirSonido(String ruta) {
        try {
            File archivo = new File(ruta);
            AudioInputStream audio = AudioSystem.getAudioInputStream(archivo);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new ReproductorEfectos();
    }
}
