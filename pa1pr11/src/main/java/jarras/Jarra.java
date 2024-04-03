package jarras;

public class Jarra {

   private final int capacidad;
   private int contenido;
    public Jarra(int cap){
        capacidad = cap;
        contenido = 0;
    }
    public int capacidad(){
        return capacidad;
    }
    public int contenido(){
        return contenido;
    }
    public void llena(){
        contenido = capacidad;
    }
    public void vacia(){
        contenido = 0;
    }
    public void llenaDesde(Jarra jarra) {
        if (this == jarra) {
            throw new RuntimeException("No se puede sumar las mismas jarras");
        } else {
            this.contenido = this.contenido + jarra.contenido;
            jarra.contenido = 0;
            if (this.contenido > capacidad) {
                int resto = this.contenido % capacidad;
                jarra.contenido = jarra.contenido + resto;
                this.contenido = capacidad;
            }
        }
    }
    @Override
    public String toString(){
        return "J(" + capacidad + "," + contenido + ")";
    }
}

