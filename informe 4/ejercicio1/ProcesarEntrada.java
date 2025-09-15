package ejercicio1;

import java.util.Scanner;

public class ProcesarEntrada {
    private Scanner scanner;

    public ProcesarEntrada() {
        this.scanner = new Scanner(System.in);
    }

    public char getNextChar() {
        System.out.print("Introduce un carácter: ");
        String input = scanner.nextLine();
        return input.isEmpty() ? ' ' : input.charAt(0);
    }

    public void procesar() throws ExcepcionVocal, ExcepcionNumero, ExcepcionBlanco, ExcepcionSalida {
        char c = getNextChar();

        if ("aeiouAEIOU".indexOf(c) != -1) {
            throw new ExcepcionVocal("Se ha detectado una vocal: " + c);
        } else if (Character.isDigit(c)) {
            throw new ExcepcionNumero("Se ha detectado un número: " + c);
        } else if (Character.isWhitespace(c)) {
            throw new ExcepcionBlanco("Se ha detectado un espacio en blanco.");
        } else if (c == 'q' || c == 'Q') {
            throw new ExcepcionSalida("Se ha detectado el carácter de salida: " + c);
        } else {
            System.out.println("Carácter procesado sin excepción: " + c);
        }
    }

    public static void main(String[] args) {
        ProcesarEntrada pe = new ProcesarEntrada();
        while (true) {
            try {
                pe.procesar();
            } catch (ExcepcionVocal | ExcepcionNumero | ExcepcionBlanco e) {
                System.out.println(e.getMessage());
            } catch (ExcepcionSalida e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
}
