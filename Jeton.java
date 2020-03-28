import java.io.Serializable;

public class Jeton implements Serializable{
    private int numero;

    public Jeton(int num) {
        this.numero = num;
    }

    public int getNumero() {
        return this.numero;
    }
}