import java.util.ArrayList;
import java.io.Serializable;

public class Grille implements Serializable {
    private ArrayList<Colonne> l_Colonnes;
    private int nbjoue;
    private double moyenne;

    public Grille() {
        this.l_Colonnes = new ArrayList<Colonne>();
        for (int i = 0; i < 7; i++)
            this.l_Colonnes.add(new Colonne());
        this.nbjoue = 0;
        this.moyenne = 0.0;
    }

    public Grille(int larg) {
        this.l_Colonnes = new ArrayList<Colonne>();
        for (int i = 0; i < larg; i++)
            this.l_Colonnes.add(new Colonne());
        this.nbjoue = 0;
        this.moyenne = 0.0;
    }

    public int nbColonne() {
        return this.l_Colonnes.size();
    }

    public void ajouter(int cgrille, int numJ) {
        this.l_Colonnes.get(cgrille).ajouter(numJ);
        this.nbjoue++;
        this.moyenne = this.nbjoue / (double) nbColonne();
    }

    public double getMoyenne() {
        return Math.round(this.moyenne * 100.0) / 100.0;
    }

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
            System.out.println("");
        }
    }

    public void trie() {
        System.out.print("N° colonnes triées par remplissage: ");
        ArrayList<String> liste = new ArrayList<String>();

        for (int i = 0; i < this.l_Colonnes.size() - 1; i++) {
            int x = this.l_Colonnes.get(i).taille();
            int y = this.l_Colonnes.get(i + 1).taille();
            if (x < y) {
                liste.add(i, "" + y);
                liste.add(i + 1, "" + x);
            } else {
                liste.add(i, "" + x);
                liste.add(i + 1, "" + y);
            }
        }
        System.out.println(this.l_Colonnes.size());
        for (int i = 0; i < liste.size(); i++) {
            System.out.print(liste.get(i));
        }

        System.out.println("");
    }
}
