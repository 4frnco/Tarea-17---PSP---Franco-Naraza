import java.util.Scanner;

// pide los datos y organiza los hilos
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

        int[] totalCompartido = {0};
        Contador[] contadores = new Contador[5];
        Thread[] hilos = new Thread[5];

        // creamos y arrancamos los hilos
        for (int i = 0; i < consonantes.length; i++) {
            contadores[i] = new Contador(
                    consonantes[i], textoRepetido, totalCompartido);

            hilos[i] = new Thread(contadores[i]);
            hilos[i].start();
        }

        // esperamos a que terminen todos los hilos
        for (int i = 0; i < hilos.length; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        teclado.close();
    }
}