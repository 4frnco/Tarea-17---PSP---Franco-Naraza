// cuenta las apariciones de una consonante
public class Contador implements Runnable {

    private char consonante;
    private String texto;
    private int apariciones;

    public Contador(char consonante, String texto) {
        this.consonante = consonante;
        this.texto = texto;
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

        System.out.println(consonante + ": " + apariciones);
    }
}