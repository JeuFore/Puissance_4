import java.io.Serializable;

public class Jeton implements Serializable {
    // Numero du jeton fesant référence au numero de joueur
    private int numero;

    /**
     * Constructeur Jeton qui construit un jeton à l'aide d'un numéro
     * 
     * @param num numéro du jeton
     */
    public Jeton(int num) {
        this.numero = num;
    }

    /**
     * Méthode permettant de retourner le numero du jeton correspond
     * 
     * @return numero du jeton
     */
    public int getNumero() {
        return this.numero;
    }
}