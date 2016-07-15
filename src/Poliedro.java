import java.util.List;
import java.util.Scanner;

/**
 * Created by professor on 16/06/2016.
 */
    public abstract class Poliedro {

    protected long id;
    protected double arista;
    protected String color;

    public Poliedro(long id, double arista, String color)
    {
        this.id =id;
        this.arista = arista;
        this.color = color;
    }

    public long getId ()
    {
        return id;

    }
    
    public abstract double CalculaVolumen();

    public String SolicitaColor(){
        return color;
    }
}


