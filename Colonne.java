import java.util.ArrayList;
import java.io.Serializable;

public class Colonne implements Serializable{
    private ArrayList<Jeton> l_Jetons;

    public Colonne() {
        this.l_Jetons = new ArrayList<Jeton>();
    }

    public void ajouter(int numJ) {
        this.l_Jetons.add(new Jeton(numJ));
    }

    public int taille(){
        return this.l_Jetons.size();
    }

    public int getJeton(int jo){
        return this.l_Jetons.get(jo).getNumero();
    }
}