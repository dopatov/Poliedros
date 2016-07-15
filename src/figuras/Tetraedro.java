package figuras;

/**
 * Created by professor on 16/06/2016.
 */
public class Tetraedro extends Poliedro {


    public Tetraedro( long id, double arista, String color)
    {
        super (id,arista,color);
        this.color = color;
    }
    public double CalculaVolumen ()
    {
        return (((Math.sqrt(2)/12)*(Math.pow(arista,3))));
    }

    public String toString()
    {
        return "figuras.Tetraedro { " +
                "id=" + id +
                ", arista=" + arista +
                ", color= " +color+
                "}";
    }
}
