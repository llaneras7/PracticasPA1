import datos2.*;
import java.util.Arrays;
import static java.lang.Double.parseDouble;

public class PruebaDatos2 {
    public static void main(String[] args){
        try {
            double min = parseDouble(args[0]);
            double max = parseDouble(args[1]);
            Datos datos = new Datos(Arrays.copyOfRange(args, 2, args.length), min, max); //Estoy indicando que el array que le paso como primer argumento será desde el tercer argumento que le pase a la función main hasta el último que le pase.
            System.out.println(datos.toString());

            try{
                datos.setRango("0;4");
                System.out.println(datos.toString());

                datos.setRango("15 25");
                System.out.println(datos.toString());
            }catch(DatosException de){
                System.out.println(de.getMessage());
            }

        }catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Error, no hay valores suficientes");
        }catch (NumberFormatException e){
            System.err.println("Error, al convertir un valor a número real ("+e.getMessage()+")");
        }



    }
}

