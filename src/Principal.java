import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nouvelle partie (N) / Charger partie existante (C)");
        try {
            Jeu j;
            int victoire;
            switch (sc.next().toUpperCase()) {
                case "N":
                    System.out.println("Combien de largeur ?");
                    int larg = sc.nextInt();
                    System.out.println("Combien de joueur ? Min 2");
                    int nbJ = sc.nextInt();
                    j = new Jeu(larg, nbJ);
                    victoire = j.jouer();
                    if (victoire != -1)
                        System.out.println("Le joueur " + victoire + " a gagné");
                    break;
                case "C":
                    j = Jeu.restaurer();
                    victoire = j.jouer();
                    if (victoire != -1)
                        System.out.println("Le joueur " + victoire + " a gagné");
                    break;
                default:
                    System.out.println("Une valeur soit N ou C !");
            }
        } catch (Exception e) {
            System.out.println("Une valeur soit N ou C !");
            System.out.println("Nom de l'erreur : \n - " + e);
        }
    }
}