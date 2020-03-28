import java.io.Serializable;

public class Joueur implements Serializable{
    private int numero;
    private int nb_victoire;
    private int nb_defaite;
    private boolean ordinateur;

    public Joueur(int num) {
        this.numero = num;
    }

    public Joueur(int num, boolean ord){
        this.numero = num;
        this.ordinateur = ord;
    }

    public int getNumero() {
        return this.numero;
    }
}