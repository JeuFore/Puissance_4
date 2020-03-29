import java.util.ArrayList;
import java.io.Serializable;

public class Colonne implements Serializable {
    // Liste de Jeton
    private ArrayList<Jeton> l_Jetons;

    /**
     * Constructeur créant une liste de Jeton
     */
    public Colonne() {
        this.l_Jetons = new ArrayList<Jeton>();
    }

    /**
     * Méthode permettant de rajouter un Jeton dans la liste
     * 
     * @param numJ numero du joueur voulant être ajouté
     */
    public void ajouter(int numJ) {
        this.l_Jetons.add(new Jeton(numJ));
    }

    /**
     * Méthode permettant de connaitre la taille de la liste
     * 
     * @return taille de liste
     */
    public int taille() {
        return this.l_Jetons.size();
    }

    /**
     * Méthode permettant de retourner le numéro d'un Jeton
     * 
     * @param indice indice corespond à l'accès de la liste
     * @return le numéro de joueur
     */
    public int getJeton(int indice) {
        return this.l_Jetons.get(indice).getNumero();
    }
}