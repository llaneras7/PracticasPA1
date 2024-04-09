package libreria;

import java.util.Arrays;

public class OfertaAutor implements OfertaFlex{

    private double descuento;
    private String[] autores;
    public OfertaAutor(double descuento, String[] autores){
        this.descuento = descuento;
        this.autores = autores;
    }
    @Override
    public double getDescuento(Libro libro){
        if(buscarLibro(libro)!=-1){ //Si he encontrado el libro
            return descuento;
        }
        return 0;
    }
    @Override
    public String toString(){
        return descuento + "%["+ Arrays.toString(autores)+"]";
    }
    public int buscarLibro(Libro libro){
        int indice = -1;
        for (int i = 0; i<autores.length; i++){
            if (libro.getAutor().equalsIgnoreCase(autores[i])){
                indice = i;
            }
        }
        return indice;
    }
}
