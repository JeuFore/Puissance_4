import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Jeu {
    private ArrayList<Joueur> l_joueurs;
    private Grille grille;
    private boolean gagne;
    private int jouer_actuel;

    public Jeu(Grille gl, ArrayList<Joueur> j, int j_actuel) {
        this.grille = gl;
        this.l_joueurs = j;
        for (int i = 1; i < 2 + 1; i++)
            this.l_joueurs.add(new Joueur(i));
        this.jouer_actuel = j_actuel;
        this.gagne = false;

        System.out.println("Restauration : OK");
        this.grille.afficher();
        this.grille.trie();
        System.out.println("Remplissage moyen: " + this.grille.getMoyenne());
    }

    public Jeu(int larg, int nbjoueurs) {
        this.grille = new Grille(larg);
        this.l_joueurs = new ArrayList<Joueur>();
        for (int i = 1; i < nbjoueurs + 1; i++)
            this.l_joueurs.add(new Joueur(i));
        this.jouer_actuel = (int) Math.round(Math.random() * (this.l_joueurs.size() - 1));
        this.gagne = false;
    }

    private int enterValue(int max) {
        Scanner sc = new Scanner(System.in);
        int val;
        try {
            val = sc.nextInt();
            if (val > max || val < 1)
                throw new Exception();
            return val;
        } catch (Exception e) {
            System.out.println("Veuillez choisir une valeur comprise entre 1 et " + max);
            return enterValue(max);
        }
    }

    public int jouer() {
        Scanner sc = new Scanner(System.in);
        String etat;
        Joueur j = this.l_joueurs.get(this.jouer_actuel);
        int choix_colonne;
        System.out.println("C'est au joueur " + j.getNumero() + " de commencer !");
        while (!this.gagne) {
            System.out.println(
                    "Joueur " + j.getNumero() + " choisir une colonne (entre 1 et " + this.grille.nbColonne() + ") :");
            choix_colonne = enterValue(this.grille.nbColonne());
            this.grille.ajouter(choix_colonne - 1, j.getNumero());
            this.grille.afficher();
            this.grille.trie();
            System.out.println("Remplissage moyen: " + this.grille.getMoyenne());
            etat = "";
            while (!etat.equals("S") && !etat.equals("R") && !etat.equals("J")) {
                System.out.println("Sauvegarder reprendre ou jouer ? (S/R/J) :");
                etat = sc.next().toUpperCase();
            }
            if (this.jouer_actuel >= (this.l_joueurs.size() - 1))
                this.jouer_actuel = 0;
            else
                this.jouer_actuel++;
            j = this.l_joueurs.get(this.jouer_actuel);
            switch (etat) {
                case "S":
                    sauvegarder();
                    return -1;

                case "R":
                    restaurer();
                    break;

                case "J":
                    break;
            }
        }
        sc.close();
        return 0;
    }

    public void sauvegarder() {
        try {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream("Puissance_4"));
            file.writeObject(this.grille);
            file.writeObject(this.l_joueurs);
            file.writeObject(this.jouer_actuel);
            file.close();
        } catch (IOException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    public static Jeu restaurer() {
        try {
            ObjectInputStream file = new ObjectInputStream(new FileInputStream("Puissance_4"));
            Jeu j = new Jeu(((Grille) file.readObject()), ((ArrayList<Joueur>) file.readObject()),
                    ((int) file.readObject()));
            file.close();
            return j;
        } catch (IOException e) {
            System.out.println(e);
            return null;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}