package libreria;

public class OfertaPrecio implements OfertaFlex{

    private double descuento;
    private double umb_precio;
    public OfertaPrecio(double descuento, double umb_precio){
        this.descuento = descuento;
        this.umb_precio = umb_precio;
    }
    @Override
    public double getDescuento(Libro libro){
        if(libro.getPrecioBase() > umb_precio){
            return descuento;
        } else {
            return 0;
        }
    }
    @Override
    public String toString(){
        return descuento + "% (" + umb_precio + ")";
    }



}
