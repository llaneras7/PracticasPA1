package libreria;
package es.uma.informatica.pa1;
import java.util.Arrays;
import java.util.ArrayList;

public class LibreriaOferta extends Libreria{
    private double descuento;
    private String[] autoresOferta;
    public LibreriaOferta(double descuento, String[] autoresOferta) {
        super();
        this.descuento = descuento;
        this.autoresOferta = autoresOferta;
    }
    public void setOferta(double descuento, String[] autoresOferta){
        this.descuento = descuento;
        this.autoresOferta = autoresOferta;
    }
    public String[] getOferta(){
        return autoresOferta;
    }
    public double getDescuento(){
        return descuento;
    }
    @Override
    public void addLibro(String autor, String titulo, double precioBase){
        int indice = buscarAutorOferta(autor);
        if(indice != -1) {
            LibroOferta nuevoLibro = new LibroOferta(autor, titulo, precioBase, getDescuento());
            anyadirLibro(nuevoLibro);
        } else {
            Libro nuevoLibro = new Libro(autor, titulo, precioBase);
            anyadirLibro(nuevoLibro);
        }
    }
    //Alternativa addLibro():
    /*
    public void addLibro(String autor, String titulo, double precioBase) {
        if (descuento > 0) {
            boolean autorEnOferta = false;
            for (String autorEnOferta : autoresEnOferta) {
                if (autor.equalsIgnoreCase(autorEnOferta)) {
                    autorEnOferta = true;
                    break; // Salimos del bucle una vez que encontramos una coincidencia
                }
            }
            if (autorEnOferta) {
                LibroOferta nuevoLibro = new LibroOferta(autor, titulo, precioBase, descuento);
                anyadirLibro(nuevoLibro);
            } else {
                Libro nuevoLibro = new Libro(autor, titulo, precioBase);
                anyadirLibro(nuevoLibro);
            }
        }
    }
     */

    private int buscarAutorOferta(String autor){
        for (int i = 0; i < autoresOferta.length; i++) {
            if(autor.equalsIgnoreCase(autoresOferta[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString(){
        return descuento + "%" + Arrays.toString(autoresOferta) + super.toString();
    }
}

