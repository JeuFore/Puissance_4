import java.util.ArrayList;
import java.io.Serializable;

public class Grille implements Serializable {
    // Liste de Colonne
    private ArrayList<Colonne> l_Colonnes;

    // Attribut permettant de savoir le nombre de fois joué
    private int nbjoue;

    // Moyenne de remplissage de la grille
    private double moyenne;

    /**
     * Constructeur créant :
     * - une liste de colonne
     * - nbjoue à 0
     * - une moyenne à 0
     */
    public Grille() {
        this.l_Colonnes = new ArrayList<Colonne>();
        for (int i = 0; i < 7; i++)
            this.l_Colonnes.add(new Colonne());
        this.nbjoue = 0;
        this.moyenne = 0.0;
    }

    /**
     * Constructeur créant :
     * - une liste de colonne de taille donnée
     * - nbjoue à 0
     * - une moyenne à 0
     * 
     * @param larg taille de la Grille
     */
    public Grille(int larg) {
        this.l_Colonnes = new ArrayList<Colonne>();
        for (int i = 0; i < larg; i++)
            this.l_Colonnes.add(new Colonne());
        this.nbjoue = 0;
        this.moyenne = 0.0;
    }

    /**
     * Méthode permettant de retourner le nombre de colonnes
     * 
     * @return nombre de colonnes
     */
    public int nbColonne() {
        return this.l_Colonnes.size();
    }

    /**
     * Méthode permettant d'ajouter un Jeton à la Grille
     * 
     * @param cgrille indice de la Grille
     * @param numJ Numéro du joueur
     */
    public void ajouter(int cgrille, int numJ) {
        this.l_Colonnes.get(cgrille).ajouter(numJ);
        this.nbjoue++;
        this.moyenne = this.nbjoue / (double) nbColonne();
    }

    /**
     * Méthode permettant de calculer la moyenne de remplissage
     * 
     * @return moyenne de remplissage
     */
    public double getMoyenne() {
        return Math.round(this.moyenne * 100.0) / 100.0;
    }

    /**
     * Méthode d'afficher correctement l'entièreté de la Grille
     */
    public void afficher() {
        int max = 0;
        int temp;
        int taille;
        for (int i = 0; i < this.l_Colonnes.size(); i++) {
            temp = this.l_Colonnes.get(i).taille();
            if (temp > max)
                max = temp;
        }

        System.out.print("+");
        for (int b = 0; b < nbColonne(); b++) {
            System.out.print("-+");
        }
        System.out.println("");
        for (int i = max - 1; i >= 0; i--) {
            for (int j = 0; j < nbColonne(); j++) {
                taille = this.l_Colonnes.get(j).taille();
                if (taille > i) {
                    System.out.print("|" + this.l_Colonnes.get(j).getJeton(i));
                } else {
                    System.out.print("| ");
                }
            }
            System.out.print("|");
            System.out.println("");
            System.out.print("+");
            for (int b = 0; b < nbColonne(); b++) {
                System.out.print("-+");
            }
            System.out.print("\n");
        }
    }

    /**
     * Méthode permettant d'afficher les numéro de colonnes triées par remplissages
     */
    public void trie() {
        System.out.print("N° colonnes triées par remplissage: ");
        ArrayList<Integer> liste = new ArrayList<Integer>();

        for (int i = 0; i < this.l_Colonnes.size(); i++)
            liste.add(this.l_Colonnes.get(i).taille());

        int temp;
        int value;
        int num_col = 0;
        for (int j = 0; j < liste.size(); j++) {
            value = -1;
            for (int h = 0; h < liste.size(); h++) {
                temp = liste.get(h);
                if (temp > value) {
                    value = temp;
                    num_col = h;
                }
            }
            System.out.print(num_col + "(" + value + ") ");
            liste.set(num_col, -1);
        }
        System.out.print("\n");
    }
}
