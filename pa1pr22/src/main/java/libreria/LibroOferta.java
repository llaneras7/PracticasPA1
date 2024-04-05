package libreria;
public class LibroOferta extends Libro{
    //Contructor libroOferta
    private double desc;
    public LibroOferta(String autor, String titulo, double precioBase, double descuento) {
        super(autor, titulo, precioBase); //Llamo al contructor padre pasandole los parametros
        desc = descuento; //Añado el descuento al nuevo constructor
    }
    public double getDescuento() {
        return desc;
    }

    @Override
    protected double getBaseImponible(){
        return super.getBaseImponible() - (super.getBaseImponible() * desc / 100);
    }
    @Override
    public String toString() {
        return "(" + getAutor() + "; " + getTitulo() + "; " + getPrecioBase() + "; "+ getIVA() + getDescuento() + "%; "+ getBaseImponible() + "; " + getPrecioFinal() + ")";
    }

}

