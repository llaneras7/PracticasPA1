package libreria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LibreriaOfertaFlex extends Libreria{

    private OfertaFlex oferta;
    public LibreriaOfertaFlex(OfertaFlex oferta){ //Constructor
       super(); //Llamo al constructor padre (creo una libreria vacía)
       setOferta(oferta);
    }
    public void setOferta(OfertaFlex oferta){
        this.oferta = oferta;
    }
    public OfertaFlex getOferta(){
        return oferta;
    }
    @Override
    public void addLibro(String aut, String tit, double pr_base){
        Libro libro = new Libro(aut, tit, pr_base);
        if(oferta.getDescuento(libro) != 0){
            libro = new LibroOferta(aut, tit, pr_base, oferta.getDescuento(libro));
        }
        anyadirLibro(libro);
    }
    @Override
    public String toString(){
            return oferta.toString() + super.toString();
    }


}
