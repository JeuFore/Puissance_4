/**
 * NumberException
 */
public class NumberException extends Exception{

    public NumberException() {
        super("La valeur entrée n'est pas correct !");
    }

    public NumberException(int max) {
        super("Veuillez choisir une valeur comprise entre 1 et " + max);
    }
}