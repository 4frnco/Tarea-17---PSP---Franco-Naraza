// cuenta las apariciones de una consonante
public class Contador implements Runnable {

    private char consonante;
    private String texto;
    private int apariciones;
    private int[] totalCompartido;

    public Contador(char consonante, String texto, int[] totalCompartido) {
        this.consonante = consonante;
        this.texto = texto;
        this.totalCompartido = totalCompartido;
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

        // sumamos las apariciones al total compartido
        totalCompartido[0] += apariciones;

        System.out.println(consonante + ": " + apariciones);
    }
}