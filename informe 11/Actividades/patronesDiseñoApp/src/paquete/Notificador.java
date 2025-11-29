package paquete;

import java.util.ArrayList;

public class Notificador {
    private ArrayList<Observador> usuarios = new ArrayList<>();

    public void agregarUsuario(Observador o) {
        usuarios.add(o);
    }

    public void eliminarUsuario(Observador o) {
        usuarios.remove(o);
    }

    public void notificar(String mensaje) {
        for (Observador o : usuarios) {
            o.actualizar(mensaje);
        }
    }
}
