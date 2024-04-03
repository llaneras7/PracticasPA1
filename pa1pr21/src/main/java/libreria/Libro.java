package libreria;

import java.util.ArrayList;
import java.util.List;

public class Libro {
    private String autor;
    private String titulo;
    private double precioBase;
    private static double porcentajeIva = 10.0; // Porcentaje de IVA compartido por todos los libros

    public Libro(String autor, String titulo, double precioBase) {
        this.autor = autor;
        this.titulo = titulo;
        this.precioBase = precioBase;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    protected double getBaseImponible() {
        return precioBase;
    }

    public double getPrecioFinal() {
        double baseImponible = getBaseImponible();
        return baseImponible + (baseImponible * porcentajeIva / 100);
    }
    @Override
    public String toString() {
        return "(" + getAutor() + "; " + getTitulo() + "; " + getPrecioBase() + "; " + porcentajeIva + "%; " + getPrecioFinal() + ")";
    }
    public static double getIVA(){
        return porcentajeIva;
    }
    public static void setIva(double porcentajeIva) {
        Libro.porcentajeIva = porcentajeIva;
    }
}


