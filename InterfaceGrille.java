/**
 * InterfaceGrille
 */
public interface InterfaceGrille {

    /**
     * Méthode permettant de retourner le nombre de colonnes
     * 
     * @return nombre de colonnes
     */
    public int nbColonne();

    /**
     * Méthode permettant d'ajouter un Jeton à la Grille
     * 
     * @param cgrille indice de la Grille
     * @param numJ Numéro du joueur
     */
    public void ajouter(int cgrille, int numJ);

    /**
     * Méthode permettant de calculer la moyenne de remplissage
     * 
     * @return moyenne de remplissage
     */
    public double getMoyenne();

    /**
     * Méthode d'afficher correctement l'entièreté de la Grille
     */
    public void afficher();

    /**
     * Méthode permettant d'afficher les numéro de colonnes triées par remplissages
     */
    public void trie();
}