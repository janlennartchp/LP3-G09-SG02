public class EmpleadoControlador {
    private EmpleadoModelo modelo;
    private EmpleadoVista vista;

    public EmpleadoControlador(EmpleadoModelo modelo, EmpleadoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    modelo.listarEmpleados();
                    break;

                case 2:
                    int num = vista.solicitarNumero();
                    String nombre = vista.solicitarNombre();
                    double sueldo = vista.solicitarSueldo();
                    modelo.agregarEmpleado(new Empleado(num, nombre, sueldo));
                    break;

                case 3:
                    int buscar = vista.solicitarNumero();
                    Empleado e = modelo.buscarEmpleado(buscar);
                    if (e != null)
                        vista.mostrarMensaje("Empleado encontrado: " + e);
                    else
                        vista.mostrarMensaje("Empleado no encontrado.");
                    break;

                case 4:
                    int eliminar = vista.solicitarNumero();
                    modelo.eliminarEmpleado(eliminar);
                    break;

                case 5:
                    vista.mostrarMensaje("Saliendo del sistema...");
                    break;

                default:
                    vista.mostrarMensaje("Opción inválida.");
                    break;
            }
        } while (opcion != 5);
    }
}
