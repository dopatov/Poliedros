package figuras;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by professor on 27/06/2016.
 */
public class Mapcolores {

    private static Map <String,List<? extends Poliedro>>mapColores = new HashMap<>();

    private static Multimap<String,Poliedro> multimapColores= ArrayListMultimap.create();

    public static void main(String[] args)
    {
        Scanner sc =new Scanner(System.in);

        System.out.println("introduce el numero de figuras a calcular");

        int numero= sc.nextInt();

        for (int id = 1; id <= numero; id++) {
            System.out.println("Introduce los datos del poliedro");
            System.out.println("Introduce el tamaño de la arista");
            double arista = sc.nextDouble();
            System.out.println("introduce el color del poliedro");

            String newLine = System.getProperty("line.separator");

            System.out.println(newLine + "1-verde" + newLine +
                    "2-azul" + newLine +
                    "3-rojo" + newLine +
                    "4-amarillo" + newLine +
                    "5-naranja");

            int selectorColor = sc.nextInt();

            String colorSeleccionado = null;

    }
}}
