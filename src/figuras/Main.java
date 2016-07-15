package figuras;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.*;
//objetivos extras del ejercicio: añadir metodos especificos para cada poliedro y utilizar el operador instanceof para
// seleccionar los objetos que sean exclusivos de esa clase.
// decir el numero de poliedros que tengan un volumen menor de 20 uds
//decir el numero de poliedros que tengan un volumen entre 20 y 100
// "     "   "     "   "       "   "          "       superior a 100
//en un metodo (clase) main nuevo "figuras.Mapcolores" crear Poliedros de diferentes colores (verde, amarillo y rojo) y estructurar los poliedros en un
// Hash map con color como K y la V la lista de figuras que tengan ese color.
//
//Sobre el proyecto global de poliedros queremos ofrecer la funcionalidad que nos permita mostrar al usuario todos los poliedros agrupados por color, para ello lo que
// haremos sera declarar un atributo adicional multimap cuya K sera de tipo String (color) y la V serà de tipo figuras.Poliedro. Cada vez que un poliedro sea pedido independientemente de su tipo se
// deberá clasificar segun su color, al finalizar dicho programa se deberá mostrar el multimap con las figuras agrupadas por colores.

public class Main {


    private static final String HEXAEDROS = "Hexaedros";
    private static final String DODECAEDROS = "Dodecaedros";
    private static final String OCTAEDROS = "Octaedros";
    private static final String TETRAEDROS = "Tetraedros";


    private static Map <String,List <? extends Poliedro>>mapPoliedros = new HashMap<>();
   private static Multimap<String, Poliedro> multimapColores = ArrayListMultimap.create();

    public static void main(String[] args) {

        String consultaRepetir="y";

        while (consultaRepetir.equalsIgnoreCase("y")){

        Scanner sc = new Scanner(System.in);
        String newLine=System.getProperty("line.separator");

        System.out.println("Hello World!");
        List<Poliedro> poliedroList = new ArrayList<>();
            int selectorInicial = getSelectorInicial(sc, newLine);
            switch (selectorInicial){
                case 1:
                    System.out.println("INSERCIÓN DE DATOS:");
        System.out.println("Introduce el numero de Poliedros de cada tipo que quieras analizar");

        int numero = sc.nextInt();

        ObtenTetraedros(sc, poliedroList, numero);

        ObtenHexaedros(sc, poliedroList, numero);

        ObtenOctaedros(sc, poliedroList, numero);

        ObtenDodecaedros(sc, poliedroList, numero);

        Poliedro max = null;



        ProcesaPoliedro(poliedroList, newLine);


        int LessThan20 = 0;
        int intermedio = 0;
        int Morethan50 = 0;

        int verde =0;
        int azul=0;
        int rojo=0;
        int amarillo=0;
        int naranja=0;

        ProcesaCantidades procesaCantidades = new ProcesaCantidades(poliedroList, LessThan20, intermedio, Morethan50, verde, azul, rojo, amarillo, naranja).invoke();
        verde = procesaCantidades.getVerde();
        azul = procesaCantidades.getAzul();
        rojo = procesaCantidades.getRojo();
        amarillo = procesaCantidades.getAmarillo();
        naranja = procesaCantidades.getNaranja();
        LessThan20 = procesaCantidades.getLessThan20();
        intermedio = procesaCantidades.getIntermedio();
        Morethan50 = procesaCantidades.getMorethan50();

        System.out.println(newLine);
                    System.out.println("POLIEDROS POR COLORES:");
        System.out.println("el numero de poliedros verdes es: " +verde );
        System.out.println("el numero de poliedros azules es: " +azul);
        System.out.println("el numero de poliedros rojos es "+rojo);
        System.out.println("el numero de poliedros amarillos es: " +amarillo);
        System.out.println("el numero de poliedros naranjas es: " +naranja);
        System.out.println(newLine);

                    System.out.println("POLIEDROS AGRUPADOS POR VOLUMEN:");
        System.out.println("El numero de poliedros con el volumen inferior a 20 es: " + LessThan20);
        System.out.println("El numero de poliedros con el volumen entre 20 y 100 es: " + intermedio);
        System.out.println("El numero de poliedros con el volumen superior a 100 es: " + Morethan50);
        System.out.println(newLine);

        mapPoliedros();
        consultarMapPoliedros(TETRAEDROS);
        consultarMapPoliedros(HEXAEDROS);
        consultarMapPoliedros(OCTAEDROS);
        consultarMapPoliedros(DODECAEDROS);

                    clasificaColor();


            System.out.println(newLine);
            System.out.println("¿Quieres volver a realizar una consulta con poliedros? [Y/N]");
                    consultaRepetir=sc.next();
            if (!consultaRepetir.equalsIgnoreCase("y")){
                System.out.println("adios");
                System.exit(0);
            }
                case 2:
                    System.out.println("adios");
                    System.exit(0);
        }}}

    private static int getSelectorInicial(Scanner sc, String newLine) {
        System.out.println(newLine);
        System.out.println("1-INICIAR CONSULTA DE POLIEDROS");
        System.out.println(newLine);
        System.out.println("2-SALIR");
        System.out.println(newLine);
        return sc.nextInt();
    }

    private static void consultarMapPoliedros(String tipoPoliedro) {
        List<Poliedro> poliedroList = (List <Poliedro>)mapPoliedros.get(tipoPoliedro);
        System.out.println("LISTA DE " + tipoPoliedro +":");
        System.out.println(poliedroList);
    }

    private static void mapPoliedros() {
        System.out.println("MAP DE POLIEDROS:");
        System.out.println(mapPoliedros);
    }

    private static void ProcesaPoliedro(List<Poliedro> poliedroList, String newLine) {
        System.out.println("VOLÚMENES DE LOS POLIEDROS INTRODUCIDOS:");
        for (Poliedro poliedro : poliedroList) {
            double VolumenActual = poliedro.CalculaVolumen();
            System.out.println(newLine);
            System.out.println("el volumen del poliedro " + (poliedro) + " es " + VolumenActual);

        }
    }

    private static void ObtenDodecaedros(Scanner sc, List<Poliedro> poliedroList, int numero) {

        List<Dodecaedro> dodecaedroList=new ArrayList<>();

        for (int id = 1; id <= numero; id++) {
            System.out.println("INSERCIÓN DE DATOS: figuras.Dodecaedro");
            System.out.println("Introduce el tamaño de la arista");
            double arista = sc.nextDouble();
            System.out.println("SELECCIÓN DE COLOR");
            String colorSeleccionado = SolicitaColor("figuras.Dodecaedro");

            Dodecaedro dodecaedro=new Dodecaedro((id+id+id+id), arista, colorSeleccionado);

            multimapColores.put(colorSeleccionado,dodecaedro);
            poliedroList.add(dodecaedro);
            dodecaedroList.add(dodecaedro);
        }

        mapPoliedros.put(DODECAEDROS,dodecaedroList);
    }

    private static void ObtenOctaedros(Scanner sc, List<Poliedro> poliedroList, int numero) {

        List <Octaedro> OctaedroList =new ArrayList<>();

        for (int id = 1; id <= numero; id++) {
            System.out.println("INSERCIÓN DE DATOS: figuras.Octaedro");
            System.out.println("Introduce el tamaño de la arista");
            double arista = sc.nextDouble();
            System.out.println("SELECCIÓN DE COLOR");
            String colorSeleccionado = SolicitaColor("figuras.Octaedro");

            Octaedro octaedro = new Octaedro((id+id+id), arista, colorSeleccionado);
            multimapColores.put(colorSeleccionado,octaedro);
            poliedroList.add(octaedro);
            OctaedroList.add(octaedro);
        }

        mapPoliedros.put(OCTAEDROS,OctaedroList);
    }

    private static void ObtenHexaedros(Scanner sc, List<Poliedro> poliedroList, int numero) {

        List <Hexaedro> HexaedroList =new ArrayList<>();

        for (int id = 1; id <= numero; id++) {
            System.out.println("INSERCIÓN DE DATOS: figuras.Hexaedro");
            System.out.println("Introduce el tamaño de la arista");
            double arista = sc.nextDouble();
            System.out.println("SELECCIÓN DE COLOR");
            String colorSeleccionado = SolicitaColor("figuras.Hexaedro");

            Hexaedro hexaedro=new Hexaedro((id+=id), arista, colorSeleccionado);

            multimapColores.put(colorSeleccionado,hexaedro);
            poliedroList.add(hexaedro);
            HexaedroList.add(hexaedro);

        }

        mapPoliedros.put(HEXAEDROS,HexaedroList);
    }

    private static void ObtenTetraedros(Scanner sc, List<Poliedro> poliedroList, int numero) {

        List <Tetraedro> TetraedroList = new ArrayList<>();

        for (int id = 1; id <= numero; id++) {
            System.out.println("INSERCIÓN DE DATOS: figuras.Tetraedro ");
            System.out.println("introduce el tamaño de la arista.");
            double arista = sc.nextDouble();
            System.out.println("SELECCIÓN DE COLOR");
            String colorSeleccionado = SolicitaColor("figuras.Tetraedro");

            Tetraedro tetraedro = new Tetraedro(id, arista, colorSeleccionado);

            multimapColores.put(colorSeleccionado,tetraedro);
            poliedroList.add(tetraedro);
            TetraedroList.add(tetraedro);
        }

        mapPoliedros.put (TETRAEDROS,TetraedroList);
    }

    private static String SolicitaColor(String tipoPoliedro) {


        String newLine = System.getProperty("line.separator");
        Scanner sc = new Scanner(System.in);

        System.out.println("introduce el color del " + tipoPoliedro);
        System.out.println(newLine + "1-verde                  2-azul" + newLine +
                                        "3-rojo                  4-amarillo" + newLine +
                "5-naranja");

        int selectorColor = sc.nextInt();

        String colorSeleccionado = null;
        switch (selectorColor) {
            case 1:
                colorSeleccionado = "verde";
                break;
            case 2:
                colorSeleccionado = "azul";
                break;
            case 3:
                colorSeleccionado = "rojo";
                break;
            case 4:
                colorSeleccionado = "amarillo";
                break;
            case 5:
                colorSeleccionado = "naranja";
                break;
            default:
                System.out.println("Numero incorrecto");
                System.exit (1);
        }
        return colorSeleccionado;
    }
    private static void clasificaColor(){

     String newLine=System.getProperty("line.separator");
        System.out.println(newLine);
        System.out.println("MAP DE POLIEDROS SEGÚN COLOR:");

        for (String color: multimapColores.keySet()) {
            System.out.println("-Mapa de poliedros de color " +color +":");
            System.out.println(multimapColores.get(color));
        }


}

    private static class ProcesaCantidades {
        private List<Poliedro> poliedroList;
        private int lessThan20;
        private int intermedio;
        private int morethan50;
        private int verde;
        private int azul;
        private int rojo;
        private int amarillo;
        private int naranja;

        public ProcesaCantidades(List<Poliedro> poliedroList, int lessThan20, int intermedio, int morethan50, int verde, int azul, int rojo, int amarillo, int naranja) {
            this.poliedroList = poliedroList;
            this.lessThan20 = lessThan20;
            this.intermedio = intermedio;
            this.morethan50 = morethan50;
            this.verde = verde;
            this.azul = azul;
            this.rojo = rojo;
            this.amarillo = amarillo;
            this.naranja = naranja;
        }

        public int getLessThan20() {
            return lessThan20;
        }

        public int getIntermedio() {
            return intermedio;
        }

        public int getMorethan50() {
            return morethan50;
        }

        public int getVerde() {
            return verde;
        }

        public int getAzul() {
            return azul;
        }

        public int getRojo() {
            return rojo;
        }

        public int getAmarillo() {
            return amarillo;
        }

        public int getNaranja() {
            return naranja;
        }

        public ProcesaCantidades invoke()
        {
            for (Poliedro poliedro : poliedroList) {

                double VolumenActual = poliedro.CalculaVolumen();


                if (VolumenActual <= 20) {
                    lessThan20++;
                } else if (VolumenActual > 20 && VolumenActual <= 100) {
                    intermedio++;
                } else {
                    morethan50++;
                }

                switch (poliedro.SolicitaColor()){
                    case "verde":
                        verde++;
                        break;
                    case "azul":
                        azul++;
                        break;
                    case "rojo":
                        rojo++;
                        break;
                    case "amarillo":
                        amarillo++;
                        break;
                    case "naranja":
                        naranja++;
                        break;
    }

            }
            return this;

        }



    }
    
}