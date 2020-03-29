import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Jeu {
    // Liste de Joueur
    private ArrayList<Joueur> l_joueurs;

    // Attribut contenant une Grille
    private Grille grille;

    // Attribut permettant de savoir quel joueur a joué en dernier
    private int jouer_actuel;

    /**
     * Constructeur qui recré un jeu à partir d'une sauvegarde
     * 
     * @param gl       Grille
     * @param j        Liste des joueurs
     * @param j_actuel joueurs qui devra jouer en premier
     */
    public Jeu(Grille gl, ArrayList<Joueur> j, int j_actuel) {
        this.grille = gl;
        this.l_joueurs = j;
        for (int i = 1; i < 2 + 1; i++)
            this.l_joueurs.add(new Joueur(i));
        this.jouer_actuel = j_actuel;

        System.out.println("Restauration : \033[32mOK\033[39m");
        this.grille.afficher();
        this.grille.trie();
        System.out.println("Remplissage moyen: \033[36m" + this.grille.getMoyenne() + "\033[0m");
    }

    /**
     * Constructeur créant un Jeu contenant : - Une Grille - Une liste de Joueur de
     * taille nbjoueurs - Le premier joueur qui devra jouer selectionné
     * aléatoirement
     * 
     * @param larg      largeur du jeu
     * @param nbjoueurs nombre de joueur du jeu
     */
    public Jeu(int larg, int nbjoueurs) {
        this.grille = new Grille(larg);
        this.l_joueurs = new ArrayList<Joueur>();
        if(nbjoueurs < 2)
            nbjoueurs = 2;
        for (int i = 1; i < nbjoueurs + 1; i++)
            this.l_joueurs.add(new Joueur(i));
        this.jouer_actuel = (int) Math.round(Math.random() * (this.l_joueurs.size() - 1));
    }

    /**
     * Méthode permettant de demander une valeur entre 1 et max
     * 
     * @param max maximum que peut entrer l'utilisateur
     * @return le nombre que l'utilisateur à rentré dans la limite donnée
     */
    private int enterValue(int max) {
        Scanner sc = new Scanner(System.in);
        int val;
        try {
            val = sc.nextInt();
            if (val > max || val < 1)
                throw new NumberException(max);
            return val;
        } catch (Exception e) {
            System.out.println(e);
            return enterValue(max);
        }
    }

    /**
     * Méthode permettant de lancer le jeu
     * 
     * @return retourne le vainqueur du jeu ou -1 si partie sauvegarder
     */
    public int jouer() {
        Scanner sc = new Scanner(System.in);
        String etat;
        Joueur j = this.l_joueurs.get(this.jouer_actuel);
        int choix_colonne;
        System.out.println("\033[33mC'est au joueur " + j.getNumero() + " de commencer !\033[39m");
        while (this.jouer_actuel != 1800) {
            System.out.println(
                    "Joueur \033[35m" + j.getNumero() + "\033[39m choisir une colonne (entre \033[31m1\033[39m et \033[31m" + this.grille.nbColonne() + "\033[39m) :");
            choix_colonne = enterValue(this.grille.nbColonne());
            this.grille.ajouter(choix_colonne - 1, j.getNumero());
            this.grille.afficher();
            this.grille.trie();
            System.out.println("Remplissage moyen: \033[36m" + this.grille.getMoyenne() + "\033[0m");
            etat = "";
            while (!etat.equals("S") && !etat.equals("R") && !etat.equals("J")) {
                System.out.println("Sauvegarder reprendre ou jouer ? (\033[32mS\033[39m/\033[31mR\033[39m/J) :");
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
        return this.jouer_actuel;
    }

    /**
     * Méthode permettant de sauvegarder l'entièreté d'une partie
     */
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

    /**
     * Méthode permettant de restaurer l'entièreté d'une partie
     * 
     * @return un objet Jeu
     */
    @SuppressWarnings("unchecked")
    public static Jeu restaurer() {
        try {
            ObjectInputStream file = new ObjectInputStream(new FileInputStream("Puissance_4"));
            Jeu j = new Jeu(((Grille) file.readObject()), ((ArrayList<Joueur>) file.readObject()),
                    ((int) file.readObject()));
            file.close();
            return j;
        } catch (IOException e) {
            System.out.println("\033[1mAucune sauvegarde trouvé\033[0m !");
            return null;
        } catch (Exception e) {
            System.out.println("\033[31m\033[1mErreur\033[0m : Impossible de restaurer la sauvegarder");
            return null;
        }
    }

    /**
     * Méthode permettant d'accéder à la liste de joueur
     * 
     * @return liste de joueur
     */
    public ArrayList<Joueur> getLJoueurs(){
        return this.l_joueurs;
    }

    /**
     * Méthode permettant d'accéder à la grille
     * 
     * @return Grille
     */
    public Grille getGrille(){
        return this.grille;
    }

    /**
     * Méthode permettant d'accéder au joueur actuel
     * 
     * @return joueur actuel
     */
    public int getJoueurActuel(){
        return this.jouer_actuel;
    }
}