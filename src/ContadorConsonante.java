import java.util.Scanner;

// pide los datos y repite el texto
public class ContadorConsonante {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        char[] consonantes = new char[5];

        // pedimos las cinco consonantes
        for (int i = 0; i < consonantes.length; i++) {
            System.out.print("introduce la consonante " + (i + 1) + ": ");
            consonantes[i] = teclado.next().charAt(0);
        }

        teclado.nextLine();

        // pedimos el texto
        System.out.print("introduce un texto: ");
        String texto = teclado.nextLine();

        // repetimos el texto 2000 veces
        String textoRepetido = texto.repeat(2000);

        System.out.println("texto repetido correctamente");
        System.out.println("longitud del texto: " + textoRepetido.length());

        teclado.close();
    }
}