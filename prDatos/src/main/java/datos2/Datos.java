package datos2;

import datos.DatosException;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;

public class Datos {
    private List<Double> datos;
    private List<String> errores;
    private double min;
    private double max;

    public Datos(String[] valores, double min, double max){
        this.datos = new ArrayList<>();
        this.errores = new ArrayList<>();
        this.min = min;
        this.max = max;

        for (String valor : valores){ //Creo una variable que tomara un valor del array valores en cada iteración
            try{
                double dato = parseDouble(valor); //Parseo cada valor del array a Double
                this.datos.add(dato); //Añado cada dato al array de datos
            }catch (NumberFormatException e){ //Si en try se genera alguna excepción se ejecutara (Es decir si el valor no puede parsearse a Double)
                this.errores.add(valor); //Añado el error al array de errores
            }
        }

    }
    public double calcMedia() throws DatosException {
        double acum = 0;
        int cont = 0;
        for (double dato : datos) {
            if (dato <= max && dato >= min) {
                acum += dato;
                cont++;
            }
        }
        if(cont==0){
            throw new DatosException("No hay datos en el rango especificado");
        }
        double media = acum/cont;
        return media;
    }
    public double desvTipica() throws DatosException {
        double media = calcMedia();
        double acum = 0;
        int cont = 0;

        for (double dato : datos){
            if (dato <= max && dato >= min) {
                acum+=Math.pow(2,(dato - media));

                cont++;
            }
        }
        if(cont == 0){
            throw new DatosException("No hay datos en el rango especificado");
        }
        double desv_tipica = Math.sqrt(acum/cont);
        return desv_tipica;
    }

    public void setRango(String rango) throws DatosException{
        try{
            int index = rango.indexOf(";");
            double r_min = parseDouble(rango.substring(0,index));
            double r_max = parseDouble(rango.substring(index+1));
            min = r_min;
            max = r_max;
        }catch (DatosException e){
            throw new DatosException("Error en los datos al establecer el rango");
        }
    }
    public List<Double> getDatos(){
        return datos;
    }
    public List<String> getErrores(){
        return errores;
    }
    @Override
    public String toString(){
        try{
            StringBuilder str = new StringBuilder().append("Min: ").append(min).append(", Max:").append(max).append(",\n [");
            for (double dato : datos){
                str.append(dato).append(", ");
            }
            str.append("],\n [");
            for (String error : errores){
                str.append(error).append(", ");
            }
            str.append("],\n ").append("Media: ").append(calcMedia()).append(" DesvTipica: ").append(desvTipica());
            return str.toString();
        }catch(Exception e){
            StringBuilder str = new StringBuilder().append("Min: ").append(min).append(", Max:").append(max).append(",\n [");
            for (double dato : datos){
                str.append(dato).append(", ");
            }
            str.append("],\n [");
            for (String error : errores){
                str.append(error).append(", ");
            }
            str.append("],\n ").append("Media: ERROR, ").append("DesvTipica: ERROR");
            return str.toString();
        }

    }
}

