package ejercicio1;

import java.io.IOException;
import java.io.InputStream;  // Añadir la importación de InputStream
import java.io.InputStreamReader;
import java.io.Reader;

public class LeerEntrada {
    private Reader stream;

    // Constructor
    public LeerEntrada(InputStream fuente) {
        this.stream = new InputStreamReader(fuente);
    }

    // Método que obtiene el siguiente carácter del teclado
    public char getChar() throws IOException {
        return (char) this.stream.read();
    }
}

