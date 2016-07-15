/**
 * Created by professor on 16/06/2016.
 */
public class Hexaedro extends Poliedro {

    public Hexaedro(long id, double arista,String color) {

        super(id,arista,color);
        this.color=color;
    }
    @Override
    public double CalculaVolumen()
    {
        return (2*Math.sqrt(3)* Math.pow(arista,2));
    }
    @Override
    public String toString()
    {
        return "Hexaedro { " +
                "id= " + id +
                ", arista= " +arista +
                ", color= " +color+
                "}";
    }
}
