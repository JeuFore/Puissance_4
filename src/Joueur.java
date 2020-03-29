import java.io.Serializable;

public class Joueur implements Serializable {
    // Numero du joueur
    private int numero;

    // Nombre de victoires du joueur
    private int nb_victoire;

    // Nombre de défaites du joueur
    private int nb_defaite;

    // Attribut qui vérifie si joueur est un ordinateur
    private boolean ordinateur;

    /**
     * Constructeur Joueur qui construit un joueur à l'aide d'un numéro
     * 
     * @param num Numéro du joueur
     */
    public Joueur(int num) {
        this.numero = num;
    }

    /**
     * Constructeur Joueur qui construit un joueur/ordinateur à l'aide d'un numéro
     * et d'un boolean
     * 
     * @param num Numéro du joueur
     * @param ord Ordinateur ou non
     */
    public Joueur(int num, boolean ord) {
        this.numero = num;
        this.ordinateur = ord;
    }

    /**
     * Méthode permettant de retourner le numero du joueur actuel
     * 
     * @return numero du joueur
     */
    public int getNumero() {
        return this.numero;
    }
}