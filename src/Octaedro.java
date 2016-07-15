/**
 * Created by professor on 16/06/2016.
 */
public class Octaedro extends Poliedro {

    public Octaedro(long id, double arista,String color)
    {
        super(id, arista,color);
        this.color = color;
    }

    @Override
    public double CalculaVolumen()
    {
        return 2*Math.sqrt(3)*(Math.pow(arista,3));
    }

    @Override
    public String toString()
    {
        return "Octaedro { " +
                "id=" + id +
                ", arista=" +arista +
                ", color= " +color+
                "}";
    }
}
