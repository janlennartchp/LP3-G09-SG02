package paquete;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ProductoApp extends JFrame {

    private JTextField nombreField, precioField, stockField;
    private JLabel resultado;
    private Producto producto;

    public ProductoApp() {
        producto = new Producto("Sin nombre", 0.0, 0);

        setTitle("Binding Manual de Datos - Producto");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        nombreField = new JTextField(15);
        precioField = new JTextField(10);
        stockField = new JTextField(5);
        resultado = new JLabel("Producto actualizado aquí…");

        JButton actualizar = new JButton("Actualizar");
        actualizar.addActionListener(this::actualizarProducto);

        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("Precio:"));
        panel.add(precioField);
        panel.add(new JLabel("Stock:"));
        panel.add(stockField);
        panel.add(actualizar);
        panel.add(resultado);

        add(panel);
    }

    private void actualizarProducto(ActionEvent e) {
        try {
            producto.setNombre(nombreField.getText());
            producto.setPrecio(Double.parseDouble(precioField.getText()));
            producto.setStock(Integer.parseInt(stockField.getText()));

            resultado.setText("✔ " + producto);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese valores válidos.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductoApp().setVisible(true));
    }
}

class Producto {
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    public void setNombre(String n) { nombre = n; }
    public void setPrecio(double p) { precio = p; }
    public void setStock(int s) { stock = s; }

    public String toString() {
        return nombre + " | S/ " + precio + " | Stock: " + stock;
    }
}
