import libtest.*;
import static libtest.Lanceur.*;
import static libtest.OutilTest.*;

/**
 * Test
 */
public class Test {

    public void test_CreationGrille(){
        Grille g1 = new Grille();
        Grille g2 = new Grille(10);
        assertEquals("La taille devrait etre 7", 7, g1.nbColonne());
        assertEquals("La taille devrait etre 10", 10, g2.nbColonne());
    }

    public void test_GrilleMoyenne(){
        Grille g1 = new Grille();
        g1.ajouter(1, 1);
        assertEquals("La moyenne devrait etre 0.14", 0.14, g1.getMoyenne());
    }

    public void test_CreationColonne(){
        Colonne c = new Colonne();
        assertEquals("La taille devrait etre 0", 0, c.taille());
    }

    public void test_ColonneAjouterJeton(){
        Colonne c = new Colonne();
        c.ajouter(1);
        assertEquals("La taille devrait etre 1", 1, c.taille());
    }

    public void test_InsertionBonJeton(){
        Colonne c = new Colonne();
        c.ajouter(2);
        assertEquals("Le joueur devrait etre le numero 2", 2, c.getJeton(0));
    }

    public void test_CreationJeton(){
        Jeton j = new Jeton(2);
        assertEquals("Le joueur devrait etre le numero 2", 2, j.getNumero());
    }

    public void test_CreationJoueur(){
        Joueur j = new Joueur(1);
        assertEquals("Le joueur devrait etre le numero 1", 1, j.getNumero());
    }

    public void test_CreationJeu(){
        Jeu j = new Jeu(11,3);
        assertEquals("Le nombre de joueur doit etre de 3", 3, j.getLJoueurs().size());
        assertEquals("Le nombre de colonne doit etre de 11", 11, j.getGrille().nbColonne());
    }

    public static void main(String[] args) {
		lancer(new Test(), args);
	}
}