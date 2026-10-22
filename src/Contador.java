// cuenta las apariciones de una consonante
public class Contador implements Runnable {

    private char consonante;
    private String texto;
    private int apariciones;
    private int[] totalCompartido;
    private Object bloqueo;

    public Contador(char consonante, String texto,
                    int[] totalCompartido, Object bloqueo) {
        this.consonante = consonante;
        this.texto = texto;
        this.totalCompartido = totalCompartido;
        this.bloqueo = bloqueo;
        this.apariciones = 0;
    }

    @Override
    public void run() {
        // contamos las apariciones de la consonante
        for (int i = 0; i < texto.length(); i++) {
            if (Character.toLowerCase(texto.charAt(i))
                    == Character.toLowerCase(consonante)) {
                apariciones++;
            }
        }

        // sumamos las apariciones al total de forma sincronizada
        synchronized (bloqueo) {
            totalCompartido[0] += apariciones;
        }

        System.out.println(consonante + ": " + apariciones);
    }
}