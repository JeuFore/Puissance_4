import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nouvelle partie \033[36m(N)\033[39m / Charger partie existante \033[31m(C)\033[39m");
        try {
            Jeu j;
            int victoire;
            switch (sc.next().toUpperCase()) {
                case "N":
                    System.out.println("Combien de largeur ? Min \033[31m2\033[39m");
                    int larg = sc.nextInt();
                    System.out.println("Combien de joueur ? Min \033[31m2\033[39m");
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
            System.out.println("La valeur rentrée n'est pas correct !");
            System.out.println("Nom de l'erreur : \n\033[31m - " + e);
        }
    }
}