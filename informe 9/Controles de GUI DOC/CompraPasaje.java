package actividad2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CompraPasaje extends JFrame {
    
    private JTextField txtNombre, txtDNI, txtFecha;
    private JCheckBox chkAudifonos, chkManta, chkRevista;
    private JRadioButton rbPrimerPiso, rbSegundoPiso;
    private JComboBox<String> cbOrigen, cbDestino;
    private JList<String> listaServicio;
    private JButton btnResumen, btnLimpiar;
    
    public CompraPasaje() {
        super("Compra de Pasajes");
        setLayout(new BorderLayout(10,10));
        
        // Panel datos
        JPanel datos = new JPanel(new GridLayout(3, 2, 5, 5));
        datos.setBorder(BorderFactory.createTitledBorder("Datos del Pasajero"));
        datos.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        datos.add(txtNombre);
        datos.add(new JLabel("DNI:"));
        txtDNI = new JTextField();
        datos.add(txtDNI);
        datos.add(new JLabel("Fecha (dd/mm/aaaa):"));
        txtFecha = new JTextField();
        datos.add(txtFecha);
        add(datos, BorderLayout.NORTH);
        
        // Panel central
        JPanel centro = new JPanel(new GridLayout(1, 2, 10, 10));
        
        // Servicios y Piso
        JPanel izq = new JPanel(new GridLayout(3,1));
        izq.setBorder(BorderFactory.createTitledBorder("Opciones"));
        
        JPanel servicios = new JPanel(new FlowLayout(FlowLayout.LEFT));
        servicios.add(new JLabel("Servicios:"));
        chkAudifonos = new JCheckBox("Audífonos");
        chkManta = new JCheckBox("Manta");
        chkRevista = new JCheckBox("Revista");
        servicios.add(chkAudifonos);
        servicios.add(chkManta);
        servicios.add(chkRevista);
        izq.add(servicios);
        
        JPanel piso = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rbPrimerPiso = new JRadioButton("1er Piso");
        rbSegundoPiso = new JRadioButton("2do Piso");
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(rbPrimerPiso);
        grupo.add(rbSegundoPiso);
        piso.add(new JLabel("Piso:"));
        piso.add(rbPrimerPiso);
        piso.add(rbSegundoPiso);
        izq.add(piso);
        
        JPanel rutas = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rutas.add(new JLabel("Origen:"));
        cbOrigen = new JComboBox<>(new String[]{"Arequipa", "Lima", "Cusco"});
        rutas.add(cbOrigen);
        rutas.add(new JLabel("Destino:"));
        cbDestino = new JComboBox<>(new String[]{"Tacna", "Puno", "Piura"});
        rutas.add(cbDestino);
        izq.add(rutas);
        
        centro.add(izq);
        
        // Lista de servicios
        JPanel der = new JPanel(new BorderLayout());
        der.setBorder(BorderFactory.createTitledBorder("Tipo de servicio"));
        listaServicio = new JList<>(new String[]{"Económico", "Standard", "VIP"});
        listaServicio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        der.add(new JScrollPane(listaServicio), BorderLayout.CENTER);
        
        centro.add(der);
        add(centro, BorderLayout.CENTER);
        
        // Botones
        JPanel botones = new JPanel();
        btnResumen = new JButton("Mostrar Resumen");
        btnLimpiar = new JButton("Limpiar");
        botones.add(btnResumen);
        botones.add(btnLimpiar);
        add(botones, BorderLayout.SOUTH);
        
        // Acción del botón Resumen
        btnResumen.addActionListener(e -> mostrarResumen());
        
        // Acción de limpiar
        btnLimpiar.addActionListener(e -> limpiar());
        
        // Configuración
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void mostrarResumen() {
        String servicios = "";
        if (chkAudifonos.isSelected()) servicios += "Audífonos ";
        if (chkManta.isSelected()) servicios += "Manta ";
        if (chkRevista.isSelected()) servicios += "Revista ";
        
        String piso = rbPrimerPiso.isSelected() ? "1er Piso" :
                     rbSegundoPiso.isSelected() ? "2do Piso" : "Sin seleccionar";
        
        String servicio = listaServicio.getSelectedValue();
        if (servicio == null) servicio = "Sin seleccionar";
        
        String mensaje = 
            "Nombre: " + txtNombre.getText() + "\n" +
            "DNI: " + txtDNI.getText() + "\n" +
            "Fecha: " + txtFecha.getText() + "\n" +
            "Origen: " + cbOrigen.getSelectedItem() + "\n" +
            "Destino: " + cbDestino.getSelectedItem() + "\n" +
            "Piso: " + piso + "\n" +
            "Servicios opcionales: " + servicios + "\n" +
            "Tipo de servicio: " + servicio;
        
        JOptionPane.showMessageDialog(this, mensaje, 
            "Resumen de Compra", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void limpiar() {
        txtNombre.setText("");
        txtDNI.setText("");
        txtFecha.setText("");
        chkAudifonos.setSelected(false);
        chkManta.setSelected(false);
        chkRevista.setSelected(false);
        rbPrimerPiso.setSelected(false);
        rbSegundoPiso.setSelected(false);
        listaServicio.clearSelection();
    }
    
    public static void main(String[] args) {
        new CompraPasaje();
    }
}
