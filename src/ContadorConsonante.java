import java.util.Scanner;

// pide los datos y organiza los hilos
public class ContadorConsonante {

    // comprueba si el texto introducido es una consonante
    public static boolean esConsonante(String entrada) {
        if (entrada.length() != 1) {
            return false;
        }

        char letra = Character.toLowerCase(entrada.charAt(0));

        String letras = "abcdefghijklmnñopqrstuvwxyz";
        String vocales = "aeiouáéíóúü";

        return letras.indexOf(letra) != -1
                && vocales.indexOf(letra) == -1;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        char[] consonantes = new char[5];

        // pedimos las cinco consonantes y validamos cada entrada
        for (int i = 0; i < consonantes.length; i++) {
            String entrada;

            do {
                System.out.print("introduce la consonante " + (i + 1) + ": ");
                entrada = teclado.next().toLowerCase();

                if (!esConsonante(entrada)) {
                    System.out.println("error: debes introducir una consonante.");
                }
            } while (!esConsonante(entrada));

            consonantes[i] = entrada.charAt(0);
        }

        teclado.nextLine();

        // pedimos el texto
        System.out.print("introduce un texto: ");
        String texto = teclado.nextLine();

        // repetimos el texto 2000 veces
        String textoRepetido = texto.repeat(2000);

        int[] totalCompartido = {0};
        Object bloqueo = new Object();

        Contador[] contadores = new Contador[5];
        Thread[] hilos = new Thread[5];

        // creamos y arrancamos los hilos
        for (int i = 0; i < consonantes.length; i++) {
            contadores[i] = new Contador(
                    consonantes[i], textoRepetido, totalCompartido, bloqueo);

            hilos[i] = new Thread(contadores[i]);
            hilos[i].start();
        }

        // esperamos a que terminen todos los hilos
        for (int i = 0; i < hilos.length; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("se ha interrumpido la espera de los hilos.");
                teclado.close();
                return;
            }
        }

        // mostramos el total compartido
        System.out.println("total compartido: " + totalCompartido[0]);

        teclado.close();
    }
}