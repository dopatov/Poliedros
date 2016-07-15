package figuras;

/**
 * Created by professor on 16/06/2016.
 */
public class Dodecaedro extends Poliedro {

    public Dodecaedro(long id, double arista, String color)

    {
        super(id, arista, color);
        this.color=color;
    }

    @Override
    public double CalculaVolumen()
    {
        return ((0.25) * (15 + (7 * (Math.sqrt(5))))) * Math.pow(arista, 3);
    }

    @Override
    public String toString()
    {
        return "figuras.Dodecaedro { " +
                "id=" + id +
                ", arista=" +arista +
                ", color= " +color+
                "}";
    }
}
