package paquete;

//Aplicación basada en la Guía de Práctica - Binding de Datos Manual con Swing
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProductoApp extends JFrame {

 // Componentes de la interfaz (Vista)
 private JTextField txtNombre;
 private JTextField txtPrecio;
 private JTextField txtCantidad;
 private JTextField txtCategoria;
 private JLabel lblResultado;

 // Modelo de datos
 private Producto producto;

 public ProductoApp() {
     setTitle("Gestión de Producto - Binding Manual");
     setSize(500, 260);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setLocationRelativeTo(null);

     // Modelo inicial vacío
     producto = new Producto("—", 0.0, 0, "—");

     // Vista
     construirInterfaz();
 }

 private void construirInterfaz() {
     setLayout(new GridLayout(6, 2, 5, 5));

     add(new JLabel("Nombre del Producto:"));
     txtNombre = new JTextField();
     add(txtNombre);

     add(new JLabel("Precio:"));
     txtPrecio = new JTextField();
     add(txtPrecio);

     add(new JLabel("Cantidad en Stock:"));
     txtCantidad = new JTextField();
     add(txtCantidad);

     add(new JLabel("Categoría:"));
     txtCategoria = new JTextField();
     add(txtCategoria);

     JButton btnActualizar = new JButton("Actualizar Producto");
     add(btnActualizar);

     lblResultado = new JLabel("Información del Producto...");
     add(lblResultado);

     // Evento del botón (Binding Manual)
     btnActualizar.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             actualizarModelo();
         }
     });
 }

 private void actualizarModelo() {
     try {
         producto.setNombre(txtNombre.getText());
         producto.setPrecio(Double.parseDouble(txtPrecio.getText()));
         producto.setCantidadStock(Integer.parseInt(txtCantidad.getText()));
         producto.setCategoria(txtCategoria.getText());

         lblResultado.setText("<html><b>Producto:</b> " + producto + "</html>");
     } catch (NumberFormatException ex) {
         JOptionPane.showMessageDialog(this,
                 "Error: Ingrese valores válidos para precio y cantidad",
                 "Validación", JOptionPane.WARNING_MESSAGE);
     }
 }

 public static void main(String[] args) {
     SwingUtilities.invokeLater(() -> new ProductoApp().setVisible(true));
 }
}

//-------------------------
//MODELO DE DATOS
//-------------------------
class Producto {
 private String nombre;
 private double precio;
 private int cantidadStock;
 private String categoria;

 public Producto(String nombre, double precio, int cantidadStock, String categoria) {
     this.nombre = nombre;
     this.precio = precio;
     this.cantidadStock = cantidadStock;
     this.categoria = categoria;
 }

 // Métodos set (permite actualización desde la vista)
 public void setNombre(String nombre) { this.nombre = nombre; }
 public void setPrecio(double precio) { this.precio = precio; }
 public void setCantidadStock(int cantidadStock) { this.cantidadStock = cantidadStock; }
 public void setCategoria(String categoria) { this.categoria = categoria; }

 // Muestra la información de forma estructurada
 @Override
 public String toString() {
     return nombre + " — S/ " + precio + " — Stock: " + cantidadStock + " — " + categoria;
 }
}
